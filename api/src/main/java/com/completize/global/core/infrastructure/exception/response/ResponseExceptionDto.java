package com.completize.global.core.infrastructure.exception.response;

import com.completize.global.core.infrastructure.exception.ResponseException;
import com.completize.global.core.infrastructure.exception.model.ResponseExceptionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * A data transfer object for serializing response exceptions into a JSON format
 * that can be sent to the client over the wire.
 * <p>
 * This DTO is used by the {@code ResponseException} class to convert the exception
 * into a JSON format that can be sent to the client. This JSON format is easier
 * to consume than the actual exception, and does not require any additional
 * information about the exception to be sent over the wire.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseExceptionDto {

    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    /**
     * Creates a ResponseExceptionDto from a given exception, HTTP status code, error and path.
     *
     * @param exception the exception to be used for creating the DTO
     * @param status    the HTTP status code to be used for the DTO
     * @param error     the error message to be used for the DTO
     * @param path      the path to be used for the DTO
     * @return a new ResponseExceptionDto containing the properties from the given parameters
     */
    public static ResponseExceptionDto of(Exception exception, int status, String error, String path) {
        final Instant now = Instant.now();
        return new ResponseExceptionDto(now, status, error, exception.getMessage(), path);
    }

    /**
     * Creates a ResponseExceptionDto from a given ResponseException.
     *
     * @param exception the ResponseException to be used for creating the DTO
     * @return a new ResponseExceptionDto containing the properties from the given ResponseException
     */
    public static ResponseExceptionDto of(ResponseException exception) {
        final ResponseExceptionEntity response = exception.getResponse();
        return new ResponseExceptionDto(response.timestamp(), response.status(), response.error(), response.message(), response.path());
    }

    /**
     * Converts this DTO to a ResponseExceptionEntity.
     *
     * @return a new ResponseExceptionEntity with the current DTO's properties
     */
    public ResponseExceptionEntity toEntity() {
        return new ResponseExceptionEntity(timestamp, status, error, message, path);
    }

}
