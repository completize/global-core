package com.completize.global.core.infrastructure.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Marks a class as an adapter for a specific service.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
@Component
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Adapter {

    /**
     * Value string.
     *
     * @return the string
     */
    @AliasFor(annotation = Component.class)
    String value() default "";

}
