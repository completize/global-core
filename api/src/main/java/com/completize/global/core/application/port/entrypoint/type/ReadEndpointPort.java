package com.completize.global.core.application.port.entrypoint.type;

import com.completize.global.core.adapter.entrypoint.model.Dto;
import com.completize.global.core.application.port.entrypoint.EndpointPort;

/**
 * Marker interface for read endpoints.
 *
 * @param <D> the type of the Dto used for the response
 * @param <I> the type of the identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface ReadEndpointPort<D extends Dto, I> extends EndpointPort {

    /**
     * Fetches a single entity of type D for the given identifier.
     *
     * @param identifier the domain identifier used to locate the entity
     * @return the fetched entity
     */
    D fetch(I identifier);

}
