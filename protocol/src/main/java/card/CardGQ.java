package card;

import cryptography.*;
import keys.PrivateKeyGQ;
import keys.PublicKeyGQ;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public class CardGQ extends AbstractCard {

    private final static Random RANDOM = new SecureRandom();

    private BigInteger r = ZERO;

    public CardGQ(String aOwnerInfo, int N) {
        // вычисляем n
        BigInteger p = BigInteger.probablePrime(N >> 2, RANDOM);
        BigInteger q = BigInteger.probablePrime(N >> 2, RANDOM);
        BigInteger n = p.multiply(q);

        // вычисляем функцию Эйлера
        BigInteger fi = Utils.eulerFunction(p, q);
        // вычисляем e
        BigInteger e;
        do {
            e = BigInteger.probablePrime(N >> 2, RANDOM);
        } while (!e.gcd(fi).equals(ONE));

        // хешируем J
        HashFunction function = new SHA1HashFunction();
        BigInteger J = new BigInteger(function.computeHash(aOwnerInfo.getBytes()));

        // Вычисляем секретный ключ X
        BigInteger s = e.modInverse(fi);
        BigInteger x = J.modPow(s.negate(), n);

        // Вычисляем открытый ключ X
        BigInteger y = x.modPow(e, n);

        // иницииализируем обязательные поля карты
        publicKey = new PublicKeyGQ(n, e, y);
        privateKey = new PrivateKeyGQ(x);
        ownerInfo = aOwnerInfo;
    }

    public BigInteger firstCheckerRequest() {
        if (r.equals(ZERO)) {
            // выбирает случайное целое  1 < r ≤ n - 1.
            r = Utils.getRandomBefore(publicKey.getN().subtract(ONE));
            //вычисляет  a=r^e mod n и отправляет его В.
            return r.modPow(publicKey.getE(), publicKey.getN());
        }
        return ZERO;
    }

    public BigInteger secondCheckerRequest(BigInteger c) {
        if (!r.equals(ZERO)) {
            // вычисляет z=rx^c mod n и посылает его В.
            BigInteger z = r.multiply(privateKey.getX().modPow(c, publicKey.getN()));
            r = ZERO;
            return z;
        }
        return ZERO;
    }
}
