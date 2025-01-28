package com.completize.global.core.application.port.entrypoint.type;

import com.completize.global.core.adapter.entrypoint.model.Dto;
import com.completize.global.core.application.port.entrypoint.EndpointPort;

import java.util.Collection;

public interface ReadAllEndpointPort<D extends Dto, I> extends EndpointPort {

    Collection<D> fetchAll(I identifier);

}
