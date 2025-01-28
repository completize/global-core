package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

public interface DeleteForUseCase<I> extends UseCase {

    void deleteFor(Domain<I> identifier);

}
