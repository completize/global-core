package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

public interface DeleteAllUseCase<I> extends UseCase {

    void deleteAll(Domain<I> identifier);

}
