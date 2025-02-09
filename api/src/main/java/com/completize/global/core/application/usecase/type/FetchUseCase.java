package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

/**
 * Defines a use case that fetches a value of type T for the given identifier.
 *
 * @param <T> The type of the value to fetch.
 * @param <I> The type of the identifier.
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface FetchUseCase<T, I> extends UseCase {

    /**
     * Fetches a value of type T for the given identifier.
     *
     * @param identifier The identifier of the value to fetch.
     * @return The fetched value.
     */
    T fetch(Domain<I> identifier);

}
