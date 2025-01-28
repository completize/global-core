package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.domain.Domain;

public interface DeleteUseCase<I> extends UseCase {

    void delete(Domain<I> identifier);

}
