package com.completize.global.core.data.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public interface Encrypt {

    String encrypt(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

}
