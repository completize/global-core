package com.completize.global.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Maps {

    public static Map<String, String> parseKeyToLowerCase(Map<String, String> map) {
        return parseKeyTo(map, Strings.Parse.LOWER_CASE);
    }

    public static Map<String, String> parseKeyToLowerCase(Map<String, String> map, boolean keep) {
        return parseKeyTo(map, keep, Strings.Parse.LOWER_CASE);
    }

    public static Map<String, String> parseKeyToLowerCase(Map<String, String> defaultMap, Map<String, String> map) {
        return parseKeyTo(defaultMap, map, Strings.Parse.LOWER_CASE);
    }

    public static Map<String, String> parseKeyToUpperCase(Map<String, String> map) {
        return parseKeyTo(map, Strings.Parse.UPPER_CASE);
    }

    public static Map<String, String> parseKeyToUpperCase(Map<String, String> map, boolean keep) {
        return parseKeyTo(map, keep, Strings.Parse.UPPER_CASE);
    }

    public static Map<String, String> parseKeyToUpperCase(Map<String, String> defaultMap, Map<String, String> map) {
        return parseKeyTo(defaultMap, map, Strings.Parse.UPPER_CASE);
    }

    public static Map<String, String> parseKeyTo(Map<String, String> map, Strings.Parse parse) {
        return parseKeyTo(map, true, parse);
    }

    public static Map<String, String> parseKeyTo(Map<String, String> map, boolean keep, Strings.Parse parse) {
        return parseKeyTo(keep ? map : new HashMap<>(), map, parse);
    }

    public static Map<String, String> parseKeyTo(Map<String, String> defaultMap, Map<String, String> map, Strings.Parse parse) {
        final Set<Map.Entry<String, String>> entries = Set.copyOf(map.entrySet());
        defaultMap.clear();
        for (Map.Entry<String, String> entry : entries)
            defaultMap.put(parse.apply(entry.getKey()), entry.getValue());
        return defaultMap;
    }

}
