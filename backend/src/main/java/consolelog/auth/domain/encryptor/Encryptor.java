package consolelog.auth.domain.encryptor;

import consolelog.global.exception.ExternalLibraryException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor implements EncryptorI {

    public Encryptor() {}

    @Override
    public String encrypt(String text) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(text.getBytes());
            // digest의 반환값은 byte 형태이므로, Hex 형태의 String 형태로 변환
            return bytesToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new ExternalLibraryException();
        }
    }

    private String bytesToHex(byte[] digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest)
            builder.append(String.format("%02x", b));
        return builder.toString();
    }
}
