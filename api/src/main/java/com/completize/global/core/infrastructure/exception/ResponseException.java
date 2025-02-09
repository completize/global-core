package com.completize.global.core.infrastructure.exception;

import com.completize.global.core.infrastructure.exception.model.ResponseExceptionEntity;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.time.Instant;

/**
 * A base class for all exceptions that should be returned to the caller with a proper status code and body.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
@Getter
public class ResponseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7148476074253859654L;

    private final ResponseExceptionEntity response;

    public ResponseException(@NonNull ResponseExceptionEntity response) {
        super(response.message());
        this.response = response;
    }

    public ResponseException(@NonNull HttpStatus status, String error, String message, String path) {
        this(new ResponseExceptionEntity(Instant.now(), status.value(), error, message, path));
    }

    public ResponseException(String error, String message, String path) {
        this(HttpStatus.BAD_REQUEST, error, message, path);
    }

}
