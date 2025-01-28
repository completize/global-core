package com.completize.global.core;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public interface Decrypt {

    String decrypt(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

}
