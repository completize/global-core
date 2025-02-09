package com.completize.global.core.function;

import java.util.Objects;

/**
 * A predicate that tests two objects.
 */
@FunctionalInterface
public interface TwoObjectPredicate<A, B> {

    /**
     * Tests the given arguments.
     *
     * @param a the first argument
     * @param b the second argument
     * @return true if the arguments are valid, false otherwise
     */
    boolean test(A a, B b);

    /**
     * Composes this predicate with the given predicate, returning a new
     * predicate that tests the given arguments with both predicates.
     *
     * @param other the predicate to compose with
     * @return a new predicate that tests the given arguments with both predicates
     */
    default TwoObjectPredicate<A, B> and(TwoObjectPredicate<A, B> other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    /**
     * Negates this predicate.
     *
     * @return a new predicate that inverts the result of this predicate
     */
    default TwoObjectPredicate<A, B> negate() {
        return (a, b) -> !test(a, b);
    }

    /**
     * Composes this predicate with the given predicate, returning a new
     * predicate that tests the given arguments with either predicate.
     *
     * @param other the predicate to compose with
     * @return a new predicate that tests the given arguments with either predicate
     */
    default TwoObjectPredicate<A, B> or(TwoObjectPredicate<A, B> other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
