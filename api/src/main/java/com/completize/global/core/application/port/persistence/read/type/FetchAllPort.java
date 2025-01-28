package com.completize.global.core.application.port.persistence.read.type;

import com.completize.global.core.application.port.persistence.read.ReaderPort;
import com.completize.global.core.domain.Domain;

import java.util.Collection;

public interface FetchAllPort<T, I> extends ReaderPort {

    Collection<T> fetchAll(Domain<I> identifier);

}
