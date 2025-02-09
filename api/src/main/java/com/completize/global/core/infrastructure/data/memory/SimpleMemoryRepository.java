package com.completize.global.core.infrastructure.data.memory;

import com.completize.global.core.infrastructure.data.MemoryRepository;
import com.completize.global.core.infrastructure.data.memory.storage.MemoryStorage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The type Simple memory repository.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 */
@RequiredArgsConstructor
public class SimpleMemoryRepository<T, ID extends Serializable> implements MemoryRepository<T, ID> {

    private final EntityInformation<T, ID> information;
    private final MemoryStorage<T, ID, Map<ID, T>> storage;

    /**
     * Saves the given entity in the in-memory storage. If an entity with the
     * same ID already exists, it will be replaced.
     *
     * @param entity the entity to be saved
     * @param <S>    the type of the entity, extending T
     * @return a Mono emitting the saved entity
     * @throws IllegalArgumentException if the entity's ID is null
     */
    @Override
    public <S extends T> Mono<S> save(S entity) {
        final ID id = extractID(entity);
        Assert.notNull(id, "Id for given entity must not be null!");
        storage.getDelegate().put(id, entity);
        return Mono.just(entity);
    }

    /**
     * Saves all given entities in the in-memory storage. If an entity with the same ID
     * already exists, it will be replaced.
     *
     * @param entities the entities to be saved
     * @param <S>      the type of the entities, extending T
     * @return a Flux emitting all saved entities
     * @throws IllegalArgumentException if any of the entity's IDs is null
     */
    @Override
    public <S extends T> Flux<S> saveAll(@NonNull Iterable<S> entities) {
        for (S entity : entities) {
            save(entity);
        }
        return Flux.fromIterable(entities);
    }

    /**
     * Saves all entities emitted by the given Publisher in the in-memory storage.
     * If an entity with the same ID already exists, it will be replaced.
     *
     * @param stream a Publisher emitting the entities to be saved
     * @param <S>    the type of the entities, extending T
     * @return a Flux emitting all saved entities
     * @throws IllegalArgumentException if any of the entity's IDs is null
     */
    @Override
    public <S extends T> Flux<S> saveAll(Publisher<S> stream) {
        final Flux<S> flux = Flux.from(stream);
        flux.map(this::save);
        return flux;
    }

    /**
     * Finds an entity with the given ID in the in-memory storage.
     *
     * @param id the ID of the entity to find
     * @return a Mono emitting the found entity, or an empty Mono if no entity with the given ID exists
     */
    @Override
    public Mono<T> findById(ID id) {
        return Mono.just(storage.getDelegate().get(id));
    }

    /**
     * Finds an entity with the given ID in the in-memory storage.
     *
     * @param id a Publisher emitting the ID of the entity to find
     * @return a Mono emitting the found entity, or an empty Mono if no entity with the given ID exists
     */
    @Override
    public Mono<T> findById(Publisher<ID> id) {
        final Mono<ID> idMono = Mono.from(id);
        return idMono.map(this::findById).block();
    }

    /**
     * Checks if an entity with the given ID exists in the in-memory storage.
     *
     * @param id the ID of the entity to check
     * @return a Mono emitting true if the entity exists, false otherwise
     */
    @Override
    public Mono<Boolean> existsById(ID id) {
        return findById(id).hasElement();
    }

    /**
     * Checks if an entity with the given ID exists in the in-memory storage.
     *
     * @param id the ID of the entity to check
     * @return a Mono emitting true if the entity exists, false otherwise
     */
    @Override
    public Mono<Boolean> existsById(Publisher<ID> id) {
        return findById(id).hasElement();
    }

    /**
     * Returns a Flux emitting all entities in the in-memory storage.
     *
     * @return a Flux emitting all entities in the storage
     */
    @Override
    public Flux<T> findAll() {
        final Iterable<T> delegate = storage.getDelegate().values();
        return Flux.fromIterable(delegate);
    }

    /**
     * Returns a Flux emitting all entities that have an ID contained in the given Iterable.
     *
     * @param ids an Iterable emitting IDs of entities to be found
     * @return a Flux emitting all entities with IDs contained in the given Iterable
     */
    @Override
    public Flux<T> findAllById(@NonNull Iterable<ID> ids) {
        final Map<ID, T> map = storage.getDelegate();
        final Set<T> values = new HashSet<>();
        for (ID id : ids) {
            final T entity = map.get(id);
            if (entity == null)
                continue;
            values.add(entity);
        }
        return Flux.fromIterable(values);
    }

    /**
     * Returns a Flux emitting all entities that have an ID contained in the given Publisher.
     *
     * @param stream a Publisher emitting IDs of entities to be found
     * @return a Flux emitting all entities with IDs emitted by the given stream
     */
    @Override
    public Flux<T> findAllById(Publisher<ID> stream) {
        final Map<ID, T> map = storage.getDelegate();
        final Set<T> values = new HashSet<>();
        Flux.from(stream).subscribe(id -> {
            final T entity = map.get(id);
            if (entity != null)
                values.add(entity);
        }).dispose();
        return Flux.fromIterable(values);
    }

    /**
     * Returns the number of elements in the in-memory storage.
     *
     * @return a Mono emitting the number of elements in the storage
     */
    @Override
    public Mono<Long> count() {
        final long size = ((Integer) storage.getDelegate().size()).longValue();
        return Mono.just(size);
    }

    /**
     * Deletes the entity with the given ID from the in-memory storage.
     *
     * @param id the ID of the entity to be deleted
     * @return a Mono that completes when the deletion is done
     */
    @Override
    public Mono<Void> deleteById(ID id) {
        storage.getDelegate().remove(id);
        return Mono.empty();
    }

    /**
     * Deletes all entities with the given IDs from the in-memory storage.
     *
     * @param stream a stream of IDs of the entities to be deleted
     * @return a Mono that completes when the deletion is done
     */
    @Override
    public Mono<Void> deleteById(Publisher<ID> stream) {
        final Map<ID, T> map = storage.getDelegate();
        Flux.from(stream).subscribe(map::remove).dispose();
        return Mono.empty();
    }

    /**
     * Deletes the specified entity from the in-memory storage.
     *
     * @param entity the entity to be deleted
     * @return a Mono that completes when the deletion is done
     */
    @Override
    public Mono<Void> delete(T entity) {
        final ID id = extractID(entity);
        storage.getDelegate().remove(id);
        return Mono.empty();
    }

    /**
     * Deletes all entities with the given IDs from the in-memory storage.
     *
     * @param ids the IDs of the entities to be deleted
     * @return a Mono that completes when the operation is done
     */
    @Override
    public Mono<Void> deleteAllById(@NonNull Iterable<? extends ID> ids) {
        final Map<ID, T> map = storage.getDelegate();
        for (ID id : ids)
            map.remove(id);
        return Mono.empty();
    }

    /**
     * Deletes all of the given entities from the in-memory storage.
     *
     * @param entities the entities to be deleted
     * @return a Mono that completes when the deletion is done
     */
    @Override
    public Mono<Void> deleteAll(@NonNull Iterable<? extends T> entities) {
        final Map<ID, T> map = storage.getDelegate();
        for (T entity : entities) {
            final ID id = extractID(entity);
            map.remove(id);
        }
        return Mono.empty();
    }

    /**
     * Deletes all entities emitted by the given stream from the in-memory storage.
     * This method is blocking until all elements in the stream have been processed.
     *
     * @param stream the stream of entities to delete
     * @return an empty Mono
     */
    @Override
    public Mono<Void> deleteAll(Publisher<? extends T> stream) {
        final Map<ID, T> map = storage.getDelegate();
        Flux.from(stream).subscribe($ -> {
            final ID id = extractID($);
            map.remove(id);
        }).dispose();
        return Mono.empty();
    }

    /**
     * Deletes all entities in the repository.
     *
     * @return a completed Mono upon deletion
     */
    @Override
    public Mono<Void> deleteAll() {
        storage.getDelegate().clear();
        return Mono.empty();
    }

    /**
     * Extracts the ID of the given entity.
     *
     * @param entity the entity whose ID to extract
     * @return the ID of the entity
     */
    private ID extractID(T entity) {
        return information.getId(entity);
    }

}
