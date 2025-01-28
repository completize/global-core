package com.completize.global.core.infrastructure.data.memory.storage;

import com.completize.global.core.infrastructure.data.EntityEntry;

public interface MemoryStorage<ID, ENTITY, DELEGATE> extends Iterable<EntityEntry<ID, ENTITY>> {

    DELEGATE getDelegate();

}
