package com.completize.global.core.data.memory.storage;

import com.completize.global.core.data.EntityEntry;

public interface MemoryStorage<ID, ENTITY, DELEGATE> extends Iterable<EntityEntry<ID, ENTITY>> {

    DELEGATE getDelegate();

}
