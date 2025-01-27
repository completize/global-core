package com.completize.global.core.data.memory.storage;

import com.completize.global.core.data.EntityEntry;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapMemoryStorage<ID, ENTITY, DELEGATE> implements MemoryStorage<ID, ENTITY, DELEGATE> {

    private final Map<ID, ENTITY> map = new ConcurrentHashMap<>();

    @Override
    public DELEGATE getDelegate() {
        return (DELEGATE) map;
    }

    @Override
    public Iterator<EntityEntry<ID, ENTITY>> iterator() {
        final Iterator<Map.Entry<ID, ENTITY>> iterator = map.entrySet().iterator();
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public EntityEntry<ID, ENTITY> next() {
                return new Entry<ID, ENTITY>(iterator.next());
            }

            @Override
            public void remove() {
                iterator.remove();
            }

        };
    }

    @RequiredArgsConstructor
    public static class Entry<ID, ENTITY> implements EntityEntry<ID, ENTITY> {

        private final Map.Entry<ID, ENTITY> entry;

        @Override
        public ID getId() {
            return entry.getKey();
        }

        @Override
        public ENTITY getEntity() {
            return entry.getValue();
        }

    }

}
