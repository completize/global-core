package com.completize.global.core.application.port.entrypoint.type;

import com.completize.global.core.adapter.entrypoint.model.Body;
import com.completize.global.core.adapter.entrypoint.model.Dto;
import com.completize.global.core.application.port.entrypoint.EndpointPort;

public interface WriteEndpointPort<D extends Dto, B extends Body, I> extends EndpointPort {

    D create(B value);
    D update(I identifier, B value);
    void delete(I identifier);

}
