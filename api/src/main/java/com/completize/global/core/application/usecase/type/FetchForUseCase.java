package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

/**
 * A use case for fetching an object for a given domain.
 *
 * @param <T> the type of the object to fetch
 * @param <I> the type of the identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface FetchForUseCase<T, I> extends UseCase {

    /**
     * Fetches the object with the given identifier.
     *
     * @param identifier the domain object that identifies the object to fetch
     * @return the fetched object
     */
    T fetchFor(Domain<I> identifier);

}
