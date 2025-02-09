package com.completize.global.core;

/**
 * An interface for validating values.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface Validator<T> {

    /**
     * Validates the provided value.
     *
     * @param value the value to be validated
     * @throws IllegalArgumentException if the value is not valid
     */
    void validate(T value);

}
