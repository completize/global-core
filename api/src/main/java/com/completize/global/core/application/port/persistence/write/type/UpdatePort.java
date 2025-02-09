package com.completize.global.core.application.port.persistence.write.type;

import com.completize.global.core.application.port.persistence.write.WriterPort;

import java.util.Optional;

/**
 * Defines a port for updating entities in the persistence layer.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface UpdatePort<T> extends WriterPort {

    /**
     * Updates the given entity in the persistence layer.
     *
     * @param value the entity to be updated
     * @return an Optional containing the updated entity, or an empty Optional if the update fails
     */
    Optional<T> update(T value);

}
