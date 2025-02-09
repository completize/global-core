package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;

/**
 * Interface for creating values.
 *
 * @param <T> the type of the value to be created
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface CreateUseCase<T> extends UseCase {

    /**
     * Creates the given value.
     *
     * @param value the value to create
     * @return the created value
     */
    T create(T value);

}
