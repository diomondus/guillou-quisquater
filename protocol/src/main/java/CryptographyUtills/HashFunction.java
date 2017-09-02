package CryptographyUtills;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public interface HashFunction {
    byte[] computeHash(byte[] data);
}
