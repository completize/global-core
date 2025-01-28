package com.completize.global.core.application.port.persistence.write.type;

import com.completize.global.core.application.port.persistence.write.WriterPort;

public interface CreatePort<T> extends WriterPort {

    T create(T value);

}
