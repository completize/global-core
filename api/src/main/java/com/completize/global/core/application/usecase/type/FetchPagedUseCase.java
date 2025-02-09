package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.infrastructure.provisional.ProvisionalPage;

import java.util.Collection;

/**
 * Fetches all values of type {@code T} with the given paging information.
 *
 * @param <T> the type of the value
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
@FunctionalInterface
public interface FetchPagedUseCase<T> extends UseCase {

    /**
     * Fetches all values of type {@code T} with the given paging information.
     *
     * @param page the paging information
     * @return the collection of values of type {@code T} that match the given paging information
     */
    Collection<T> fetchAll(ProvisionalPage page);

}
