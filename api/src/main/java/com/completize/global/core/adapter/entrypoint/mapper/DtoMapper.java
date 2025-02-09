package com.completize.global.core.adapter.entrypoint.mapper;


import com.completize.global.core.adapter.entrypoint.model.Body;
import com.completize.global.core.adapter.entrypoint.model.Dto;
import com.completize.global.core.domain.Domain;

/**
 * Defines a mapper that converts a domain object into a dto and vice versa.
 *
 * @param <ID> the type of the identifier
 * @param <D>  the type of the dto object
 * @param <B>  the type of the request body
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface DtoMapper<ID, D extends Dto, B extends Body> {

    /**
     * Converts the given identifier into a dto object.
     *
     * @param value the identifier
     * @return the dto object
     */
    D toDto(ID value);

    /**
     * Converts the given request body into a domain object.
     *
     * @param value the request body
     * @return the domain object
     */
    Domain<ID> toDomainFrom(B value);

    /**
     * Converts a given identifier and a given request body into a domain object.
     *
     * @param id    the identifier
     * @param value the request body
     * @return the domain object
     */
    Domain<ID> toDomainFrom(ID id, B value);

}
