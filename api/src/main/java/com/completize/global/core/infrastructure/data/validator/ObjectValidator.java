package com.completize.global.core.infrastructure.data.validator;

import com.completize.global.core.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

/**
 * The type Object validator.
 */
public final class ObjectValidator implements Validator<Object> {

    /**
     * The constant INSTANCE.
     */
    public static final Validator<Object> INSTANCE = new ObjectValidator();

    /**
     * Validates the given object using Jakarta Bean Validation.
     *
     * @param value the object to be validated
     * @throws ConstraintViolationException if any constraint violations are found
     */
    @Override
    public void validate(Object value) {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            final jakarta.validation.Validator validator = factory.getValidator();
            final Set<ConstraintViolation<Object>> violations = validator.validate(value);
            if (!violations.isEmpty())
                throw new ConstraintViolationException(violations);
        }
    }

}
