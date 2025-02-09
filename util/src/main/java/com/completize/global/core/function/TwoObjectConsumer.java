package com.completize.global.core.function;

import java.util.Objects;

/**
 * Represents an operation that accepts two input arguments and returns no
 * result.  This is the two-arity specialization of {@link java.util.function.Consumer}.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #accept(Object, Object)}.
 *
 * @param <A> the type of the first argument to the operation
 * @param <B> the type of the second argument to the operation
 * @see java.util.function.Consumer
 * @since 1.8
 */
@FunctionalInterface
public interface TwoObjectConsumer<A, B> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param a the first argument
     * @param b the second argument
     */
    void accept(A a, B b);

    /**
     * Returns a composed {@code TwoObjectConsumer} that performs, in sequence,
     * this operation followed by the {@code after} operation. If performing
     * either operation throws an exception, it is relayed to the caller of
     * the composed operation.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code TwoObjectConsumer} that performs in sequence
     * this operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default TwoObjectConsumer<A, B> andThen(TwoObjectConsumer<A, B> after) {
        Objects.requireNonNull(after);
        return (A a, B b) -> {
            accept(a, b);
            after.accept(a, b);
        };
    }

}
