import cryptography.Utils;
import card.CardGQ;
import keys.PublicKeyGQ;

import java.math.BigInteger;

import static java.math.BigInteger.*;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public class Checker {

    public boolean check(CardGQ cardGQ) {

        PublicKeyGQ publicKey = (PublicKeyGQ) cardGQ.getPublicKey();

        // Сторона А, 1 шаг проверки
        BigInteger a = cardGQ.firstCheckerRequest();

        // Сторона B, 2 шаг проверки
        // выбирает случайное целое c, находящееся в диапазоне от 1 до e - 1
        BigInteger c = Utils.getRandomBefore(publicKey.getE().subtract(ONE));

        // Сторона А, 3 шаг проверки
        BigInteger z = cardGQ.secondCheckerRequest(c);

        // Сторона B, 4 шаг проверки
        // проверяет: если z^e=ay^c (mod n), то подлинность доказана.
        BigInteger z1 = z.modPow(publicKey.getE(), publicKey.getN());
        BigInteger z2 = a.multiply(publicKey.getY().modPow(c, publicKey.getN())).mod(publicKey.getN());
        boolean res = z1.equals(z2);

        return res;
    }
}