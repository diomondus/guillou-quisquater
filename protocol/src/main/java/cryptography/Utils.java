package cryptography;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public class Utils {

    private final static Random RANDOM = new SecureRandom();
    private final static HashFunction HASH_FUNCTION = new SHA1HashFunction();

    public static BigInteger eulerFunction(BigInteger p, BigInteger q) {
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }

    public static BigInteger getRandomBefore(BigInteger number) {
        BigInteger generated;
        do {
            generated = BigInteger.probablePrime(number.bitCount(), RANDOM);
        } while (generated.compareTo(number) > 0);

        return generated;
    }

    public static byte[] encrypt(String password, byte[] data) {
        byte[] passwordBytes = password.getBytes();
        byte[] hashBytes = HASH_FUNCTION.computeHash(passwordBytes);

        for (int i = 0; i < hashBytes.length && i< data.length; ++i) {
            data[i] += hashBytes[i];
        }
        return data;
    }

    public static byte[] decrypt(String password, byte[] data) {
        byte[] passwordBytes = password.getBytes();
        byte[] hashBytes = HASH_FUNCTION.computeHash(passwordBytes);

        for (int i = 0; i < hashBytes.length && i< data.length; ++i) {
            data[i] -= hashBytes[i];
        }
        return data;
    }
}
