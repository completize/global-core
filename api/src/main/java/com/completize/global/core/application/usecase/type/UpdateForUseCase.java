package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

public interface UpdateForUseCase<T, I> extends UseCase {

    T updateFor(Domain<I> identifier, T value);

}
