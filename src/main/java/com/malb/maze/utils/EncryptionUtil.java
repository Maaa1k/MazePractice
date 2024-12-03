package com.malb.maze.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128; // Tamaño de clave AES (128 bits, 192 bits o 256 bits)

    // Método para generar una clave AES
    public static String generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(KEY_SIZE);
            SecretKey secretKey = keyGenerator.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException("Error al generar la clave AES", e);
        }
    }

    // Método para encriptar datos
    public static String encrypt(String data, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedData = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar datos", e);
        }
    }

    // Método para desencriptar datos
    public static String decrypt(String encryptedData, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decodedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decodedData);
        } catch (Exception e) {
            throw new RuntimeException("Error al desencriptar datos", e);
        }
    }
}
