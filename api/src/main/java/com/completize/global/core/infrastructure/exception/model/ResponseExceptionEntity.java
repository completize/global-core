package com.completize.global.core.infrastructure.exception.model;

import java.io.Serializable;
import java.time.Instant;

/**
 * A serializable entity for representing response exceptions.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public record ResponseExceptionEntity(Instant timestamp, int status, String error, String message,
                                      String path) implements Serializable {
}
