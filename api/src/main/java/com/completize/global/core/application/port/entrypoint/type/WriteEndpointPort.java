package com.completize.global.core.application.port.entrypoint.type;

import com.completize.global.core.adapter.entrypoint.model.Body;
import com.completize.global.core.adapter.entrypoint.model.Dto;
import com.completize.global.core.application.port.entrypoint.EndpointPort;

/**
 * Marker interface for write endpoints.
 *
 * @param <D> the type of the Dto used for the response
 * @param <B> the type of the Body used for the request
 * @param <I> the type of the identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface WriteEndpointPort<D extends Dto, B extends Body, I> extends EndpointPort {

    /**
     * Create a new entity.
     *
     * @param value the value containing the info to create the entity
     * @return the created entity
     */
    D create(B value);

    /**
     * Update an existing entity.
     *
     * @param identifier the identifier of the entity to update
     * @param value      the value containing the info to update the entity
     * @return the updated entity
     */
    D update(I identifier, B value);

    /**
     * Delete an existing entity.
     *
     * @param identifier the identifier of the entity to delete
     */
    void delete(I identifier);

}
