package com.completize.global.core.application.port.persistence.read.type;

import com.completize.global.core.application.port.persistence.read.ReaderPort;
import com.completize.global.core.domain.Domain;

import java.util.Optional;

/**
 * Interface for fetching an entity of type T from a persistence store.
 *
 * @param <T> the type of the entity
 * @param <I> the type of the domain identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface FetchPort<T, I> extends ReaderPort {

    /**
     * Fetches an entity of type T based on the provided domain identifier.
     *
     * @param identifier the domain identifier used to locate the entity
     * @return an Optional containing the entity if found, or an empty Optional if not found
     */
    Optional<T> fetch(Domain<I> identifier);

}
