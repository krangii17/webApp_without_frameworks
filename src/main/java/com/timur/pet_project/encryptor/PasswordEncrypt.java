package com.timur.pet_project.encryptor;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncrypt {

    public static String encodePassword(String password) {
        Base64 base64 = new Base64();
        String encodedVersion = new String(base64.encode(password.getBytes()));
        return encodedVersion;
    }

    public static String decodePassword(String password) {
        Base64 base64 = new Base64();
        String decodedVersion = new String(base64.decode(password.getBytes()));
        return decodedVersion;
    }

}
