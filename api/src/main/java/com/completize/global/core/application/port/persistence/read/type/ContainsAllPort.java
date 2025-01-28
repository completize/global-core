package com.completize.global.core.application.port.persistence.read.type;

import com.completize.global.core.application.port.persistence.read.ReaderPort;
import com.completize.global.core.domain.Domain;

public interface ContainsAllPort<I> extends ReaderPort {

    boolean containsAll(Domain<I> identifier);

}
