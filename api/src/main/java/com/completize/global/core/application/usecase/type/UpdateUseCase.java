package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;

/**
 * An interface for updating entities.
 *
 * @param <T> the type of entity to be updated
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface UpdateUseCase<T> extends UseCase {

    /**
     * Updates an entity with the given value.
     *
     * @param value the value to update the entity with
     * @return the updated entity
     */
    T update(T value);

}
