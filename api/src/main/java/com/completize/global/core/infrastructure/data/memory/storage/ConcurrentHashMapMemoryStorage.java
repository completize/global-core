package com.completize.global.core.infrastructure.data.memory.storage;

import com.completize.global.core.infrastructure.data.EntityEntry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Concurrent hash map memory storage.
 *
 * @param <ID>       the type parameter
 * @param <ENTITY>   the type parameter
 * @param <DELEGATE> the type parameter
 */
public class ConcurrentHashMapMemoryStorage<ID, ENTITY, DELEGATE> implements MemoryStorage<ID, ENTITY, DELEGATE> {

    private final Map<ID, ENTITY> map = new ConcurrentHashMap<>();

    /**
     * Returns the delegate used by this memory storage.
     *
     * @return the delegate, of type {@code DELEGATE}
     */
    @Override
    @SuppressWarnings("unchecked")
    public DELEGATE getDelegate() {
        return (DELEGATE) map;
    }

    /**
     * Returns an iterator over elements of type {@code EntityEntry<ID, ENTITY>}.
     *
     * @return an Iterator.
     */
    @NonNull
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

    /**
     * The type Entry.
     *
     * @param <ID>     the type parameter
     * @param <ENTITY> the type parameter
     */
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
