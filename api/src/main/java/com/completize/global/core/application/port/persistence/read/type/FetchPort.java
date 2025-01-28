package com.completize.global.core.application.port.persistence.read.type;

import com.completize.global.core.application.port.persistence.read.ReaderPort;
import com.completize.global.core.domain.Domain;

import java.util.Optional;

public interface FetchPort<T, I> extends ReaderPort {

    Optional<T> fetch(Domain<I> identifier);

}
