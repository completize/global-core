package com.completize.global.core.infrastructure.provisional;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * A base class for marking classes as provisional.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
@Getter
@SuperBuilder
public abstract class Provisional<T> {

    protected final T value;

}
