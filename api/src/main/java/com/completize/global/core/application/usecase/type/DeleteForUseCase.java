package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

/**
 * Interface for deleting an entity identified by a domain identifier.
 *
 * @param <I> the type of the domain identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface DeleteForUseCase<I> extends UseCase {

    /**
     * Deletes an entity identified by the specified domain identifier.
     *
     * @param identifier the domain identifier of the entity to be deleted
     */
    void deleteFor(Domain<I> identifier);

}
