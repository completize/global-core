package com.completize.global.core.infrastructure.data;

import org.reactivestreams.Publisher;
import org.springframework.data.repository.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

/**
 * The interface Memory repository.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 */
public interface MemoryRepository<T, ID extends Serializable> extends Repository<T, ID> {

    /**
     * Save mono.
     *
     * @param <S>    the type parameter
     * @param entity the entity
     * @return the mono
     */
    <S extends T> Mono<S> save(S entity);

    /**
     * Save all flux.
     *
     * @param <S>      the type parameter
     * @param entities the entities
     * @return the flux
     */
    <S extends T> Flux<S> saveAll(Iterable<S> entities);

    /**
     * Save all flux.
     *
     * @param <S>          the type parameter
     * @param entityStream the entity stream
     * @return the flux
     */
    <S extends T> Flux<S> saveAll(Publisher<S> entityStream);

    /**
     * Find by id mono.
     *
     * @param id the id
     * @return the mono
     */
    Mono<T> findById(ID id);

    /**
     * Find by id mono.
     *
     * @param id the id
     * @return the mono
     */
    Mono<T> findById(Publisher<ID> id);

    /**
     * Exists by id mono.
     *
     * @param id the id
     * @return the mono
     */
    Mono<Boolean> existsById(ID id);

    /**
     * Exists by id mono.
     *
     * @param id the id
     * @return the mono
     */
    Mono<Boolean> existsById(Publisher<ID> id);

    /**
     * Find all flux.
     *
     * @return the flux
     */
    Flux<T> findAll();

    /**
     * Find all by id flux.
     *
     * @param ids the ids
     * @return the flux
     */
    Flux<T> findAllById(Iterable<ID> ids);

    /**
     * Find all by id flux.
     *
     * @param idStream the id stream
     * @return the flux
     */
    Flux<T> findAllById(Publisher<ID> idStream);

    /**
     * Count mono.
     *
     * @return the mono
     */
    Mono<Long> count();

    /**
     * Delete by id mono.
     *
     * @param id the id
     * @return the mono
     */
    Mono<Void> deleteById(ID id);

    /**
     * Delete by id mono.
     *
     * @param id the id
     * @return the mono
     */
    Mono<Void> deleteById(Publisher<ID> id);

    /**
     * Delete mono.
     *
     * @param entity the entity
     * @return the mono
     */
    Mono<Void> delete(T entity);

    /**
     * Delete all by id mono.
     *
     * @param ids the ids
     * @return the mono
     */
    Mono<Void> deleteAllById(Iterable<? extends ID> ids);

    /**
     * Delete all mono.
     *
     * @param entities the entities
     * @return the mono
     */
    Mono<Void> deleteAll(Iterable<? extends T> entities);

    /**
     * Delete all mono.
     *
     * @param entityStream the entity stream
     * @return the mono
     */
    Mono<Void> deleteAll(Publisher<? extends T> entityStream);

    /**
     * Delete all mono.
     *
     * @return the mono
     */
    Mono<Void> deleteAll();

}
