package com.completize.global.core.application.port.persistence.write.type;

import com.completize.global.core.application.port.persistence.write.WriterPort;

/**
 * A port that provides a way to create a new entity in the persistence storage.
 *
 * @param <T> the type of the entity to be created
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface CreatePort<T> extends WriterPort {

    /**
     * Creates a new entity of type T and returns it.
     *
     * @param value the value to be created
     * @return the created entity
     */
    T create(T value);

}
