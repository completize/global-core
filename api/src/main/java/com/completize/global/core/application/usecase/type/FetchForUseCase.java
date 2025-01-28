package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

public interface FetchForUseCase<T, I> extends UseCase {

    T fetchFor(Domain<I> identifier);

}
