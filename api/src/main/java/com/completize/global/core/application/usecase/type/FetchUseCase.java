package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

public interface FetchUseCase<T, I> extends UseCase {

    T fetch(Domain<I> identifier);

}
