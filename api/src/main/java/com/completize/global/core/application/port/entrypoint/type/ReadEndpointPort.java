package com.completize.global.core.application.port.entrypoint.type;

import com.completize.global.core.adapter.entrypoint.model.Dto;
import com.completize.global.core.application.port.entrypoint.EndpointPort;

public interface ReadEndpointPort<D extends Dto, I> extends EndpointPort {

    D fetch(I identifier);

}
