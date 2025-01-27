package com.completize.global.core.exception;

import com.completize.global.core.exception.model.ResponseExceptionEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
public class ResponseException extends RuntimeException {

    private final ResponseExceptionEntity response;

    public ResponseException(ResponseExceptionEntity response) {
        super(response.message());
        this.response = response;
    }

    public ResponseException(HttpStatus status, String error, String message, String path) {
        this(new ResponseExceptionEntity(Instant.now(), status.value(), error, message, path));
    }

    public ResponseException(String error, String message, String path) {
        this(HttpStatus.BAD_REQUEST, error, message, path);
    }

}
