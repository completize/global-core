package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

import java.util.Collection;

/**
 * A use case for fetching all entities of a given type associated with a given
 * domain identifier.
 *
 * @param <T> the type of the entities to fetch
 * @param <I> the type of the domain identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface FetchAllUseCase<T, I> extends UseCase {

    /**
     * Fetches all entities of type T associated with the given identifier.
     *
     * @param identifier the domain identifier used to fetch the entities
     * @return a collection of entities of type T
     */
    Collection<T> fetchAll(Domain<I> identifier);

}
