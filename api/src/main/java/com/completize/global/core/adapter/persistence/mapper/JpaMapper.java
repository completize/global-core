package com.completize.global.core.adapter.persistence.mapper;

import com.completize.global.core.adapter.persistence.model.JpaData;
import com.completize.global.core.domain.Domain;

/**
 * The JpaMapper interface provides methods to map between domain objects and JPA entities.
 *
 * @param <ID> the type of the domain identifier
 * @param <J>  the type of the JPA entity, extending JpaData
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface JpaMapper<ID, J extends JpaData> {

    /**
     * Maps a given domain to the corresponding JPA entity.
     *
     * @param value the domain to be mapped
     * @return the JPA entity corresponding to the given domain
     */
    J toJpa(Domain<ID> value);

    /**
     * Maps a given domain to the corresponding JPA entity.
     *
     * @param value the domain to be mapped
     * @param jpa   the JPA entity, which may be null or not null
     * @return the JPA entity corresponding to the given domain
     */
    J toJpa(Domain<ID> value, J jpa);

    /**
     * Maps a given JPA entity to the corresponding domain.
     *
     * @param jpa the JPA entity to be mapped
     * @return the domain corresponding to the given JPA entity
     */
    Domain<ID> toDomain(J jpa);

}