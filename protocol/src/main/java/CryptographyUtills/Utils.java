package CryptographyUtills;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public class Utils {

    private final static Random RANDOM = new SecureRandom();

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
}
