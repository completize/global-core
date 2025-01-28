package com.completize.global.core;

import java.util.Map;

public class Primitive {

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

    public static Class<?> translate(Class<?> type) {
        final Class<?> conversion = PRIMITIVE_MAP.get(type);
        return conversion != null ? conversion : type;
    }

}
