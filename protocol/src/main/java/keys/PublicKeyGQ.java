package keys;

import lombok.Getter;

import java.math.BigInteger;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public class PublicKeyGQ extends PublicKey {
    @Getter
    private BigInteger y; // открытый ключ

    public PublicKeyGQ(BigInteger n, BigInteger e, BigInteger y) {
        super(n, e);
        this.y = y;
    }
}