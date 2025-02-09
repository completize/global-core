package com.completize.global.core.infrastructure.exception;

import com.completize.global.core.infrastructure.exception.model.ResponseExceptionEntity;
import org.springframework.http.HttpStatus;

import java.io.Serial;

/**
 * Thrown when an entity is not found.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public class EntityNotFoundException extends ResponseException {

    @Serial
    private static final long serialVersionUID = -7576199214772837100L;

    private static final String DEFAULT_ERROR = "Entity not found";

    public EntityNotFoundException(ResponseExceptionEntity response) {
        super(response);
    }

    public EntityNotFoundException(HttpStatus status, String error, String message, String path) {
        super(status, error, message, path);
    }

    public EntityNotFoundException(String error, String message, String path) {
        super(error, message, path);
    }

    public EntityNotFoundException(HttpStatus status, String message, String path) {
        super(status, DEFAULT_ERROR, message, path);
    }

    public EntityNotFoundException(String message, String path) {
        super(DEFAULT_ERROR, message, path);
    }

}
