package com.completize.global.core;

import java.util.Map;

/**
 * Utility class for working with primitive types.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public final class Primitive {

    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP = Map.of(
            boolean.class, Boolean.class,
            byte.class, Byte.class,
            char.class, Character.class,
            double.class, Double.class,
            float.class, Float.class,
            int.class, Integer.class,
            long.class, Long.class,
            short.class, Short.class
    );

    /**
     * Returns the corresponding primitive wrapper class for the given primitive type, or the input
     * type if no such mapping exists.
     *
     * @param type the type to translate
     * @return the translated type
     */
    public static Class<?> translate(Class<?> type) {
        final Class<?> conversion = PRIMITIVE_MAP.get(type);
        return conversion != null ? conversion : type;
    }

}
