package com.completize.global.core.infrastructure.data;

public interface EntityEntry<ID, ENTITY> {

    ID getId();
    ENTITY getEntity();

}
