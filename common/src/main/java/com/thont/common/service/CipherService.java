package com.thont.common.service;//package com.common.service;
//
//import javax.crypto.*;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.PBEKeySpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.InvalidAlgorithmParameterException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.KeySpec;
//import java.util.Base64;
//
//public class CipherService {
//    private final String key = ":$ZQ*T/,6>j=gJ\\A";
//    private final String algorithm = "AES";
//
//   private SecretKey getKeyFromPassword(String password, String salt)
//            throws NoSuchAlgorithmException, InvalidKeySpecException {
//
//        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
//        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
//                .getEncoded(), "AES");
//        return secret;
//    }
//
//    private String encrypt(String content) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
//        String plainText = "www.baeldung.com";
//        String password = "baeldung";
//        String salt = "12345678";
//        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
//        SecretKey key = getKeyFromPassword(key,salt);
//        String cipherText = AESUtil.encryptPasswordBased(plainText, key, ivParameterSpec);
//        String decryptedCipherText = AESUtil.decryptPasswordBased(
//                cipherText, key, ivParameterSpec);
//        Assertions.assertEquals(plainText, decryptedCipherText);
//
//
//
//        SecretKey key = Base64.;
//
//
//
//            Cipher cipher = Cipher.getInstance(algorithm);
//            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
//            byte[] cipherText = cipher.doFinal(content.getBytes());
//            return Base64.getEncoder()
//                    .encodeToString(cipherText);
//    }
//
//    String decrypt(String algorithm, String cipherText, SecretKey key,
//                   IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
//            InvalidAlgorithmParameterException, InvalidKeyException,
//            BadPaddingException, IllegalBlockSizeException {
//
//        Cipher cipher = Cipher.getInstance(algorithm);
//        cipher.init(Cipher.DECRYPT_MODE, key, iv);
//        byte[] plainText = cipher.doFinal(Base64.getDecoder()
//                .decode(cipherText));
//        return new String(plainText);
//    }
//}
