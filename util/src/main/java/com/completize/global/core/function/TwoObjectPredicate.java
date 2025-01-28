package com.completize.global.core.function;

import java.util.Objects;

@FunctionalInterface
public interface TwoObjectPredicate<A, B> {

    boolean test(A a, B b);

    default TwoObjectPredicate<A, B> and(TwoObjectPredicate<A, B> other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    default TwoObjectPredicate<A, B> negate() {
        return (a, b) -> !test(a, b);
    }

    default TwoObjectPredicate<A, B> or(TwoObjectPredicate<A, B> other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
