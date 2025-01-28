package com.completize.global.core.application.port.persistence.write.type;

import com.completize.global.core.application.port.persistence.write.WriterPort;

import java.util.Optional;

public interface UpdatePort<T> extends WriterPort {

    Optional<T> update(T value);

}
