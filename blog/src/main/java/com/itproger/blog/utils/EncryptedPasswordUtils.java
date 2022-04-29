package com.itproger.blog.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtils
{
    public static String EncryptPassword(String password)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args)
    {
        String password = "11110000";
        String encryptedPassword = EncryptPassword(password);
        System.out.println("Encrypted Password: " + encryptedPassword);
    }
}
