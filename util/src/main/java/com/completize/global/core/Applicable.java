package com.completize.global.core;

import java.util.function.Consumer;

/**
 * An interface for objects that can be applied with a consumer.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface Applicable<T extends Applicable> {

    /**
     * Applies the given consumer to this object.
     *
     * @param apply the consumer to apply
     * @return this object
     */
    @SuppressWarnings("unchecked")
    default T apply(Consumer<T> apply) {
        final T object = (T) this;
        apply.accept(object);
        return object;
    }

}
