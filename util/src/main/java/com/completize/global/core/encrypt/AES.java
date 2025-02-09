package com.completize.global.core.encrypt;

import com.completize.global.core.Decrypt;
import com.completize.global.core.Encrypt;
import lombok.NonNull;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * Encrypts and decrypts strings using AES.
 *
 * @author wgs
 * @version 1.0
 * @since 1.0
 */
public class AES implements Encrypt, Decrypt {

    private static final String ALGORITHM = "AES";

    private final Key key;
    private final Cipher cipher;

    /**
     * Constructs an AES encrypter and decrypter using the specified key.
     *
     * @param secret the key to use for encryption and decryption
     * @throws NoSuchPaddingException   if the padding is not available
     * @throws NoSuchAlgorithmException if the specified algorithm is not available
     */
    public AES(SecretKeySpec secret) throws NoSuchPaddingException, NoSuchAlgorithmException {
        key = secret;
        cipher = Cipher.getInstance(ALGORITHM);
    }

    /**
     * Constructs an AES encrypter and decrypter using the specified key.
     *
     * @param secret the key to use for encryption and decryption
     * @throws NoSuchPaddingException   if the padding is not available
     * @throws NoSuchAlgorithmException if the specified algorithm is not available
     */
    public AES(@NonNull String secret) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this(new SecretKeySpec(secret.getBytes(), ALGORITHM));
    }

    /**
     * Encrypts the given string using AES encryption.
     *
     * @param value the string to encrypt
     * @return the encrypted string, encoded in base64
     * @throws InvalidKeyException       if the encryption key is invalid
     * @throws IllegalBlockSizeException if the block size is illegal
     * @throws BadPaddingException       if the padding is incorrect
     */
    @Override
    public String encrypt(@NonNull String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
    }

    /**
     * Decrypts the given base64-encoded string using AES.
     *
     * @param value the base64-encoded string to decrypt
     * @return the decrypted string
     * @throws InvalidKeyException       if the key is invalid
     * @throws IllegalBlockSizeException if the block size is illegal
     * @throws BadPaddingException       if the padding is incorrect
     */
    @Override
    public String decrypt(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
    }

    /**
     * Encrypts and decrypts strings using AES.
     *
     * @author wgs
     * @version 1.0
     * @since 1.0
     */
    public static class KeyGenerator {

        private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
        private static final int PASSWORD_ITERATORS = 65536;
        private static final int KEY_SIZE = 128;
        private static final byte[] SALT_BYTES = {0, 1, 2, 3, 4, 5, 6};

        /**
         * Generates a SecretKeySpec using the provided password.
         *
         * @param password the password to use for key generation
         * @return a SecretKeySpec object for AES encryption
         * @throws NoSuchAlgorithmException if the specified algorithm is not available
         * @throws InvalidKeySpecException  if the key specification is invalid
         */
        @NonNull
        public static SecretKeySpec generate(@NonNull String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
            final SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            final PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT_BYTES, PASSWORD_ITERATORS, KEY_SIZE);
            final SecretKey secretKey = factory.generateSecret(spec);
            return new SecretKeySpec(secretKey.getEncoded(), AES.ALGORITHM);
        }

    }

}
