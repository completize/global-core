package com.completize.global.core;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

/**
 * Interface for encrypting values.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface Encrypt {

    /**
     * Encrypts the given value using the current encryption key.
     *
     * @param value The value to encrypt.
     * @return The encrypted value.
     * @throws InvalidKeyException       if the current key is invalid.
     * @throws IllegalBlockSizeException if the given value is not a multiple of the block size.
     * @throws BadPaddingException       if the given value is not properly padded.
     */
    String encrypt(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

}
