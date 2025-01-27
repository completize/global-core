package com.completize.global.core.exception.response;

import com.completize.global.core.exception.ResponseException;
import com.completize.global.core.exception.model.ResponseExceptionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseExceptionDto {

    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public static ResponseExceptionDto of(Exception exception, int status, String error, String path) {
        final Instant now = Instant.now();
        return new ResponseExceptionDto(now, status, error, exception.getMessage(), path);
    }

    public static ResponseExceptionDto of(ResponseException exception) {
        final ResponseExceptionEntity response = exception.getResponse();
        return new ResponseExceptionDto(response.timestamp(), response.status(), response.error(), response.message(), response.path());
    }

    public ResponseExceptionEntity toEntity() {
        return new ResponseExceptionEntity(timestamp, status, error, message, path);
    }

}
