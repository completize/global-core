package com.completize.global.core;

import lombok.RequiredArgsConstructor;

import java.util.function.Function;

public final class Strings {

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isBlank(String string) {
        boolean result = true;
        for (int i = 0; i < string.length(); i++)
            result = result && Character.isWhitespace(string.charAt(i));
        return result;
    }

    public static boolean isNullOrBlank(String string) {
        return isNullOrEmpty(string) || isBlank(string);
    }

    public static String parseToLowerCase(String string) {
        return parseTo(string, Parse.LOWER_CASE);
    }

    public static String parseToUpperCase(String string) {
        return parseTo(string, Parse.UPPER_CASE);
    }

    public static String parseTo(String string, Parse parse) {
        return parse.apply(string);
    }

    @RequiredArgsConstructor
    public enum Parse {

        LOWER_CASE(String::toLowerCase),
        UPPER_CASE(String::toUpperCase);

        private final Function<String, String> function;

        public String apply(String value) {
            return function.apply(value);
        }

    }

}
