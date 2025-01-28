package com.completize.global.core.application.port.persistence.read.type;

import com.completize.global.core.application.port.persistence.read.ReaderPort;
import com.completize.global.core.domain.Domain;

public interface ContainsPort<I> extends ReaderPort {

    boolean contains(Domain<I> identifier);

}
