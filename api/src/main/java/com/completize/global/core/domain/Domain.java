package com.completize.global.core.domain;

/**
 * The interface Domain.
 *
 * @param <T> the type parameter
 */
public interface Domain<T> {

    /**
     * Returns the ID of the entity.
     *
     * @return the ID of the entity, may be null
     */
    T id();

}
