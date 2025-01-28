package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

import java.util.Collection;

public interface FetchAllUseCase<T, I> extends UseCase {

    Collection<T> fetchAll(Domain<I> identifier);

}
