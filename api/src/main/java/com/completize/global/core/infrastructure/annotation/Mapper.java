package com.completize.global.core.infrastructure.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Marks a class as a Spring component, indicating that the class is a candidate
 * for component scanning. This annotation can be used to auto-detect custom
 * mappers and make them available in the application context.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
@Component
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mapper {

    /**
     * Value string.
     *
     * @return the string
     */
    @AliasFor(annotation = Component.class)
    String value() default "";

}
