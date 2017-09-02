package keys;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigInteger;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
@AllArgsConstructor
public abstract class PrivateKey {
    @Getter
    private BigInteger x; // G - закрытый ключ
}
