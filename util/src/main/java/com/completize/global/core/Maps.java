package com.completize.global.core;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Utility class for working with maps.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public final class Maps {

    /**
     * Parses all keys in the given map to lowercase.
     *
     * @param map the map to parse
     * @return a new map with all keys converted to lowercase
     */
    @NonNull
    public static Map<String, String> parseKeyToLowerCase(Map<String, String> map) {
        return parseKeyTo(map, Strings.Parse.LOWER_CASE);
    }

    /**
     * Parses all keys in the given map to lowercase.
     *
     * @param map  the map to parse
     * @param keep whether to keep the original map and return a new one, or
     *             modify the original map
     * @return a new map with all keys converted to lowercase, or the input map
     * if {@code keep} is {@code false}
     */
    @NonNull
    public static Map<String, String> parseKeyToLowerCase(Map<String, String> map, boolean keep) {
        return parseKeyTo(map, keep, Strings.Parse.LOWER_CASE);
    }

    /**
     * Parses all keys in the given map to lowercase.
     *
     * @param defaultMap the map to return if the given map is null
     * @param map        the map to parse
     * @return a new map with all keys converted to lowercase, or the input map
     * if {@code keep} is {@code false}, or the default map if the
     * given map is null
     */
    @NonNull
    public static Map<String, String> parseKeyToLowerCase(Map<String, String> defaultMap, Map<String, String> map) {
        return parseKeyTo(defaultMap, map, Strings.Parse.LOWER_CASE);
    }

    /**
     * Parses all keys in the given map to uppercase.
     *
     * @param map the map to parse
     * @return a new map with all keys converted to uppercase
     */
    @NonNull
    public static Map<String, String> parseKeyToUpperCase(Map<String, String> map) {
        return parseKeyTo(map, Strings.Parse.UPPER_CASE);
    }

    /**
     * Parses all keys in the given map to uppercase.
     *
     * @param map  the map to parse
     * @param keep whether to keep the original map and return a new one, or
     *             modify the original map
     * @return a new map with all keys converted to uppercase, or the input map
     * if {@code keep} is {@code false}
     */
    @NonNull
    public static Map<String, String> parseKeyToUpperCase(Map<String, String> map, boolean keep) {
        return parseKeyTo(map, keep, Strings.Parse.UPPER_CASE);
    }

    /**
     * Parses all keys in the given map to uppercase.
     *
     * @param defaultMap the map to return if the given map is null
     * @param map        the map to parse
     * @return a new map with all keys converted to uppercase, or the default map if the
     * given map is null
     */
    @NonNull
    public static Map<String, String> parseKeyToUpperCase(Map<String, String> defaultMap, Map<String, String> map) {
        return parseKeyTo(defaultMap, map, Strings.Parse.UPPER_CASE);
    }

    /**
     * Parses all keys in the given map using the specified parse strategy.
     *
     * @param map   the map whose keys are to be parsed
     * @param parse the parse strategy to apply, either LOWER_CASE or UPPER_CASE
     * @return a new map with all keys parsed according to the specified strategy
     */
    @NonNull
    public static Map<String, String> parseKeyTo(Map<String, String> map, Strings.Parse parse) {
        return parseKeyTo(map, true, parse);
    }

    /**
     * Parses all keys in the given map using the specified parse strategy.
     *
     * @param map   the map whose keys are to be parsed
     * @param keep  whether to keep the original map and return a new one, or
     *              modify the original map
     * @param parse the parse strategy to apply, either LOWER_CASE or UPPER_CASE
     * @return a new map with all keys parsed according to the specified strategy,
     * or the input map if {@code keep} is {@code false}
     */
    @NonNull
    public static Map<String, String> parseKeyTo(Map<String, String> map, boolean keep, Strings.Parse parse) {
        return parseKeyTo(keep ? map : new HashMap<>(), map, parse);
    }

    /**
     * Parses all keys in the given map using the specified parse strategy.
     *
     * @param defaultMap the map to return if the given map is null, and the map
     *                   to which the parsed keys will be added
     * @param map        the map whose keys are to be parsed
     * @param parse      the parse strategy to apply, either LOWER_CASE or UPPER_CASE
     * @return the {@code defaultMap} with all keys parsed according to the specified
     * strategy
     */
    @NonNull
    public static Map<String, String> parseKeyTo(@NonNull Map<String, String> defaultMap, @NonNull Map<String, String> map, Strings.Parse parse) {
        final Set<Map.Entry<String, String>> entries = Set.copyOf(map.entrySet());
        defaultMap.clear();
        for (Map.Entry<String, String> entry : entries)
            defaultMap.put(parse.apply(entry.getKey()), entry.getValue());
        return defaultMap;
    }

}
