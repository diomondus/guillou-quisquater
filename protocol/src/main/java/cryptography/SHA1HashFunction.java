package cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public class SHA1HashFunction
        implements HashFunction {

    @Override
    public byte[] computeHash(byte[] data) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(data);
        return md.digest();
    }
}
