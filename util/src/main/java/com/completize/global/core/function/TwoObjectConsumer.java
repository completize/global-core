package com.completize.global.core.function;

import java.util.Objects;

@FunctionalInterface
public interface TwoObjectConsumer<A, B> {

    void accept(A a, B b);

    default TwoObjectConsumer<A, B> andThen(TwoObjectConsumer<A,B> after) {
        Objects.requireNonNull(after);
        return (A a, B b) -> { accept(a, b); after.accept(a, b); };
    }

}
