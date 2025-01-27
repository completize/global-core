package com.completize.global.core.exception;

import com.completize.global.core.exception.model.ResponseExceptionEntity;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ResponseException {

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
