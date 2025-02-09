package com.completize.global.core;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

/**
 * Utility class for working with strings.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public final class Strings {

    /**
     * Tests if the given string is null or empty.
     *
     * @param string The string to test.
     * @return true if the string is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    /**
     * Checks if the provided string contains only whitespace characters.
     *
     * @param string The string to check for whitespace.
     * @return true if the string consists solely of whitespace characters, false otherwise.
     * @throws NullPointerException if the string is null.
     */
    public static boolean isBlank(@NonNull String string) {
        boolean result = true;
        for (int i = 0; i < string.length(); i++)
            result = result && Character.isWhitespace(string.charAt(i));
        return result;
    }

    /**
     * Tests if the given string is null, empty, or contains only whitespace.
     *
     * @param string The string to test.
     * @return true if the string is null, empty, or contains only whitespace,
     * false otherwise.
     */
    public static boolean isNullOrBlank(String string) {
        return isNullOrEmpty(string) || isBlank(string);
    }

    /**
     * Converts all characters in the given string to lowercase.
     *
     * @param string The string to convert to lowercase.
     * @return The string with all characters converted to lowercase.
     * @throws NullPointerException if the string is null.
     */
    public static String parseToLowerCase(String string) {
        return parseTo(string, Parse.LOWER_CASE);
    }

    /**
     * Converts all characters in the given string to uppercase.
     *
     * @param string The string to convert to uppercase.
     * @return The string with all characters converted to uppercase.
     * @throws NullPointerException if the string is null.
     */
    public static String parseToUpperCase(String string) {
        return parseTo(string, Parse.UPPER_CASE);
    }

    /**
     * Parses the given string using the specified parse strategy.
     *
     * @param string The string to be parsed.
     * @param parse  The parse strategy to apply, either LOWER_CASE or UPPER_CASE.
     * @return The parsed string after applying the specified parse strategy.
     * @throws NullPointerException if the parse parameter is null.
     */
    public static String parseTo(String string, @NonNull Parse parse) {
        return parse.apply(string);
    }

    @RequiredArgsConstructor
    public enum Parse {

        LOWER_CASE(String::toLowerCase),
        UPPER_CASE(String::toUpperCase);

        private final Function<String, String> function;

        /**
         * Applies the parse function to the given string.
         *
         * @param value The string to parse.
         * @return The parsed string.
         */
        public String apply(String value) {
            return function.apply(value);
        }

    }

}
