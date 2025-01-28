package com.completize.global.core.infrastructure.provisional;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class Provisional<T> {

    protected final T value;

}
