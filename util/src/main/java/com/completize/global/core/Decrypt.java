package com.completize.global.core;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

/**
 * An interface for decrypting values.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public interface Decrypt {

    /**
     * Decrypts the given value.
     *
     * @param value the value to decrypt
     * @return the decrypted value
     * @throws InvalidKeyException       if the key is not valid
     * @throws IllegalBlockSizeException if the block size is not valid
     * @throws BadPaddingException       if the padding is not valid
     */
    String decrypt(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

}
