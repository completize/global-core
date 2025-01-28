package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;

public interface UpdateUseCase<T> extends UseCase {

    T update(T value);

}
