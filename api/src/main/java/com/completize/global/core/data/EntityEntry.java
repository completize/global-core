package com.completize.global.core.data;

public interface EntityEntry<ID, ENTITY> {

    ID getId();
    ENTITY getEntity();

}
