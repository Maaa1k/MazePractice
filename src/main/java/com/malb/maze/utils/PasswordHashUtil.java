package com.malb.maze.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHashUtil {

    // Genera un hash de la contraseña usando SHA-256
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] salt = generateSalt();
            md.update(salt); // Agrega el salt a la contraseña
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar el hash de la contraseña", e);
        }
    }

    // Verifica si la contraseña proporcionada coincide con el hash almacenado
    public static boolean verifyPassword(String rawPassword, String storedPassword) {
        try {
            String[] parts = storedPassword.split(":");
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] storedHash = Base64.getDecoder().decode(parts[1]);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(rawPassword.getBytes());

            return MessageDigest.isEqual(hashedPassword, storedHash);
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar la contraseña", e);
        }
    }

    // Genera un salt seguro de 16 bytes
    private static byte[] generateSalt() {
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        return salt;
    }
}
