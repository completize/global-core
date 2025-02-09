package com.completize.global.core.application.port.persistence.write.type;

import com.completize.global.core.application.port.persistence.write.WriterPort;
import com.completize.global.core.domain.Domain;

/**
 * This interface defines a contract for deleting all entities by a given identifier.
 *
 * @param <I> the type of the identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface DeleteAllPort<I> extends WriterPort {

    /**
     * Delete all by id.
     *
     * @param identifier the identifier
     */
    void deleteAll(Domain<I> identifier);

}
