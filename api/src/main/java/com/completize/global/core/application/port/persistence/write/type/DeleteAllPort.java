package com.completize.global.core.application.port.persistence.write.type;

import com.completize.global.core.application.port.persistence.write.WriterPort;
import com.completize.global.core.domain.Domain;

public interface DeleteAllPort<I> extends WriterPort {

    void deleteAll(Domain<I> identifier);

}
