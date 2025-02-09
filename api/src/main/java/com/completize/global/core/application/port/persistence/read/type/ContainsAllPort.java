package com.completize.global.core.application.port.persistence.read.type;

import com.completize.global.core.application.port.persistence.read.ReaderPort;
import com.completize.global.core.domain.Domain;

/**
 * The ContainsAllPort interface provides a method to determine if a given domain
 * identifier contains all elements within this port.
 *
 * @param <I> the type of the domain identifier
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface ContainsAllPort<I> extends ReaderPort {

    /**
     * Determines whether the given domain identifier contains all of the elements in this
     * port.
     *
     * @param identifier the domain identifier
     * @return true if this port contains all the elements in the given domain identifier
     */
    boolean containsAll(Domain<I> identifier);

}
