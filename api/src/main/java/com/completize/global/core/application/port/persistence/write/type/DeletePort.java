package com.completize.global.core.application.port.persistence.write.type;

import com.completize.global.core.application.port.persistence.write.WriterPort;
import com.completize.global.core.domain.Domain;

/**
 * The interface Delete port.
 *
 * @param <I> the type parameter
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface DeletePort<I> extends WriterPort {

    /**
     * Delete mono.
     *
     * @param identifier the identifier
     */
    void delete(Domain<I> identifier);

}
