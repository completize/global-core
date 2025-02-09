package com.completize.global.core.infrastructure.exception;

import com.completize.global.core.infrastructure.exception.model.ResponseExceptionEntity;
import org.springframework.http.HttpStatus;

import java.io.Serial;

/**
 * An exception that is thrown when a resource is not found.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public class ResourceNotFoundException extends ResponseException {

    @Serial
    private static final long serialVersionUID = -8024843378821242673L;

    private static final String DEFAULT_ERROR = "Resource not found";

    public ResourceNotFoundException(ResponseExceptionEntity response) {
        super(response);
    }

    public ResourceNotFoundException(HttpStatus status, String error, String message, String path) {
        super(status, error, message, path);
    }

    public ResourceNotFoundException(String error, String message, String path) {
        super(error, message, path);
    }

    public ResourceNotFoundException(HttpStatus status, String message, String path) {
        super(status, DEFAULT_ERROR, message, path);
    }

    public ResourceNotFoundException(String message, String path) {
        super(DEFAULT_ERROR, message, path);
    }

}
