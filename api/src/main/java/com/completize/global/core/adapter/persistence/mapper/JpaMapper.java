package com.completize.global.core.adapter.persistence.mapper;

import com.completize.global.core.adapter.persistence.model.JpaData;
import com.completize.global.core.domain.Domain;

public interface JpaMapper<ID, J extends JpaData> {

    J toJpa(Domain<ID> value);
    J toJpa(Domain<ID> value, J jpa);
    Domain<ID> toDomain(J jpa);

}