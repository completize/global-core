package com.completize.global.core.infrastructure.exception;

import com.completize.global.core.infrastructure.exception.model.ResponseExceptionEntity;
import org.springframework.http.HttpStatus;

import java.io.Serial;

/**
 * Exception thrown when an attempt is made to create an entity that already exists.
 * <p>
 * This exception should be used to signal that a requested operation on an entity
 * cannot be performed because it already exists in the system.
 *
 * @see ResponseException
 * @see EntityNotFoundException
 * @see ResourceNotFoundException
 */
public class EntityAlreadyExistsException extends ResponseException {

    @Serial
    private static final long serialVersionUID = -550140757301464664L;

    private static final String DEFAULT_ERROR = "Entity already exists";

    public EntityAlreadyExistsException(ResponseExceptionEntity response) {
        super(response);
    }

    public EntityAlreadyExistsException(HttpStatus status, String error, String message, String path) {
        super(status, error, message, path);
    }

    public EntityAlreadyExistsException(String error, String message, String path) {
        super(error, message, path);
    }

    public EntityAlreadyExistsException(HttpStatus status, String message, String path) {
        super(status, DEFAULT_ERROR, message, path);
    }

    public EntityAlreadyExistsException(String message, String path) {
        super(DEFAULT_ERROR, message, path);
    }

}
