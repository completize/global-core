package com.completize.global.core.adapter.entrypoint.mapper;


import com.completize.global.core.adapter.entrypoint.model.Body;
import com.completize.global.core.adapter.entrypoint.model.Dto;
import com.completize.global.core.domain.Domain;

public interface DtoMapper<ID, D extends Dto, B extends Body> {

    D toDto(ID value);
    Domain<ID> toDomainFrom(B value);
    Domain<ID> toDomainFrom(ID id, B value);

}
