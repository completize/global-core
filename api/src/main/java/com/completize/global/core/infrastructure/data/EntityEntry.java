package com.completize.global.core.infrastructure.data;

/**
 * The interface Entity entry.
 *
 * @param <ID>     the type parameter
 * @param <ENTITY> the type parameter
 */
public interface EntityEntry<ID, ENTITY> {

    /**
     * Gets id.
     *
     * @return the id
     */
    ID getId();

    /**
     * Gets entity.
     *
     * @return the entity
     */
    ENTITY getEntity();

}
