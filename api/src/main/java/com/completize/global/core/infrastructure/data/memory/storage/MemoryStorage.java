package com.completize.global.core.infrastructure.data.memory.storage;

import com.completize.global.core.infrastructure.data.EntityEntry;

/**
 * The interface Memory storage.
 *
 * @param <ID>       the type parameter
 * @param <ENTITY>   the type parameter
 * @param <DELEGATE> the type parameter
 */
public interface MemoryStorage<ID, ENTITY, DELEGATE> extends Iterable<EntityEntry<ID, ENTITY>> {

    /**
     * Gets delegate.
     *
     * @return the delegate
     */
    DELEGATE getDelegate();

}
