package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;

public interface CreateUseCase<T> extends UseCase {

    T create(T value);

}
