package com.completize.global.core.application.port.persistence.read.type;

import com.completize.global.core.application.port.persistence.read.ReaderPort;
import com.completize.global.core.domain.Domain;

/**
 * The type Contains port.
 *
 * <p>
 * This interface is intended to be implemented by any ports that are responsible for
 * checking if the identifier is contained by the target data.
 *
 * @param <I> the type of the identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface ContainsPort<I> extends ReaderPort {

    /**
     * Determines if the given identifier is contained by the target data.
     *
     * @param identifier the identifier to be checked
     * @return true if the identifier is found, false otherwise
     */
    boolean contains(Domain<I> identifier);

}
