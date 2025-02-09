package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

/**
 * Defines a use case for deleting entities.
 *
 * @param <I> The type of the identifier.
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface DeleteUseCase<I> extends UseCase {

    /**
     * Deletes the entity associated with the given identifier.
     *
     * @param identifier The identifier of the entity to delete.
     */
    void delete(Domain<I> identifier);

}
