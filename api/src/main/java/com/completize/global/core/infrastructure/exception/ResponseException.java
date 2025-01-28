package com.completize.global.core.infrastructure.exception;

import com.completize.global.core.infrastructure.exception.model.ResponseExceptionEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.time.Instant;

@Getter
public class ResponseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7148476074253859654L;

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
