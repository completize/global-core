package com.completize.global.core.application.port.persistence.read.type;

import com.completize.global.core.application.port.persistence.read.ReaderPort;
import com.completize.global.core.domain.Domain;

import java.util.Collection;

/**
 * The type Fetch all port.
 *
 * @param <T> the type parameter
 * @param <I> the type parameter
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface FetchAllPort<T, I> extends ReaderPort {

    /**
     * Retrieves a collection of {@link T} for the given {@link Domain}.
     *
     * @param identifier the {@link Domain} to fetch for
     * @return a collection of {@link T}
     */
    Collection<T> fetchAll(Domain<I> identifier);

}
