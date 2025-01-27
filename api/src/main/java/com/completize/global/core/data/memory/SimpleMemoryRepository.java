package com.completize.global.core.data.memory;

import com.completize.global.core.data.MemoryRepository;
import com.completize.global.core.data.memory.storage.MemoryStorage;
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

@RequiredArgsConstructor
public class SimpleMemoryRepository<T, ID extends Serializable> implements MemoryRepository<T, ID> {

    private final EntityInformation<T, ID> information;
    private final MemoryStorage<T, ID, Map<ID, T>> storage;

    @Override
    public <S extends T> Mono<S> save(S entity) {
        final ID id = extractID(entity);
        Assert.notNull(id, "Id for given entity must not be null!");
        storage.getDelegate().put(id, entity);
        return Mono.just(entity);
    }

    @Override
    public <S extends T> Flux<S> saveAll(Iterable<S> entities) {
        for (S entity : entities) {
            save(entity);
        }
        return Flux.fromIterable(entities);
    }

    @Override
    public <S extends T> Flux<S> saveAll(Publisher<S> stream) {
        final Flux<S> flux = Flux.from(stream);
        flux.map(this::save);
        return flux;
    }

    @Override
    public Mono<T> findById(ID id) {
        return Mono.just(storage.getDelegate().get(id));
    }

    @Override
    public Mono<T> findById(Publisher<ID> id) {
        final Mono<ID> idMono = Mono.from(id);
        return idMono.map(this::findById).block();
    }

    @Override
    public Mono<Boolean> existsById(ID id) {
        return findById(id).hasElement();
    }

    @Override
    public Mono<Boolean> existsById(Publisher<ID> id) {
        return findById(id).hasElement();
    }

    @Override
    public Flux<T> findAll() {
        final Iterable<T> delegate = storage.getDelegate().values();
        return Flux.fromIterable(delegate);
    }

    @Override
    public Flux<T> findAllById(Iterable<ID> ids) {
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

    @Override
    public Mono<Long> count() {
        final Integer size = storage.getDelegate().size();
        return Mono.just(size.longValue());
    }

    @Override
    public Mono<Void> deleteById(ID id) {
        storage.getDelegate().remove(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> deleteById(Publisher<ID> stream) {
        final Map<ID, T> map = storage.getDelegate();
        Flux.from(stream).subscribe(map::remove).dispose();
        return Mono.empty();
    }

    @Override
    public Mono<Void> delete(T entity) {
        final ID id = extractID(entity);
        storage.getDelegate().remove(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<? extends ID> ids) {
        final Map<ID, T> map = storage.getDelegate();
        for (ID id : ids)
            map.remove(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends T> entities) {
        final Map<ID, T> map = storage.getDelegate();
        for (T entity : entities) {
            final ID id = extractID(entity);
            map.remove(id);
        }
        return Mono.empty();
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends T> stream) {
        final Map<ID, T> map = storage.getDelegate();
        Flux.from(stream).subscribe($ -> {
            final ID id = extractID($);
            map.remove(id);
        }).dispose();
        return Mono.empty();
    }

    @Override
    public Mono<Void> deleteAll() {
        storage.getDelegate().clear();
        return Mono.empty();
    }

    private ID extractID(T entity) {
        return information.getId(entity);
    }

}
