package com.completize.global.core.application.usecase.type;

import com.completize.global.core.application.usecase.UseCase;
import com.completize.global.core.infrastructure.provisional.ProvisionalPage;

import java.util.Collection;

public interface FetchPagedUseCase<T> extends UseCase {

    Collection<T> fetchAll(ProvisionalPage page);

}
