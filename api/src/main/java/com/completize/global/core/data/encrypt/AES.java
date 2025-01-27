package com.completize.global.core.data.encrypt;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class AES implements Encrypt, Decrypt {

    private static final String AES = "AES";

    private final Key key;
    private final Cipher cipher;

    public AES(SecretKeySpec secret) throws NoSuchPaddingException, NoSuchAlgorithmException {
        key = secret;
        cipher = Cipher.getInstance(AES);
    }

    public AES(String secret) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this(new SecretKeySpec(secret.getBytes(), AES));
    }

    @Override
    public String encrypt(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
    }

    @Override
    public String decrypt(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
    }

    public static class KeyGenerator {

        private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
        private static final int PASSWORD_ITERATORS = 65536;
        private static final int KEY_SIZE = 128;
        private static final byte[] SALT_BYTES = {0, 1, 2, 3, 4, 5, 6};

        public static SecretKeySpec generate(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
            final SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            final PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT_BYTES, PASSWORD_ITERATORS, KEY_SIZE);
            final SecretKey secretKey = factory.generateSecret(spec);
            return new SecretKeySpec(secretKey.getEncoded(), AES);
        }


    }

}
