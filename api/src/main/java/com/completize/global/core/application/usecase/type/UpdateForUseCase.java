package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

/**
 * An interface for use cases that update an object for a given identifier.
 *
 * @param <T> the type of the object to update
 * @param <I> the type of the identifier of the object to update
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface UpdateForUseCase<T, I> extends UseCase {

    /**
     * Updates the object with the given identifier to the given value.
     *
     * @param identifier the identifier of the object to update
     * @param value      the new value of the object
     * @return the updated object
     */
    T updateFor(Domain<I> identifier, T value);

}
