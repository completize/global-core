package com.completize.global.core.application.port.entrypoint.type;

import com.completize.global.core.adapter.entrypoint.model.Dto;
import com.completize.global.core.application.port.entrypoint.EndpointPort;

import java.util.Collection;

/**
 * Interface for reading all entities of type D for the given identifier.
 *
 * @param <D> the type of the entities to fetch
 * @param <I> the type of the identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface ReadAllEndpointPort<D extends Dto, I> extends EndpointPort {

    /**
     * Fetches all entities of type D for the given identifier.
     *
     * @param identifier the identifier of the entities to fetch
     * @return a collection of entities of type D
     */
    Collection<D> fetchAll(I identifier);

}
