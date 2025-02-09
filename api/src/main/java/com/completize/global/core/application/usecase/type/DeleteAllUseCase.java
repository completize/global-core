package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

/**
 * An interface for deleting all elements of a given domain.
 *
 * @param <I> the type of the identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface DeleteAllUseCase<I> extends UseCase {

    /**
     * Deletes all elements of the given domain.
     *
     * @param identifier the identifier of the domain
     */
    void deleteAll(Domain<I> identifier);

}
