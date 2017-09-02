package card;

import keys.PrivateKey;
import keys.PublicKey;
import lombok.Getter;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
abstract class AbstractCard {
    @Getter
    protected PublicKey publicKey;
    @Getter
    protected PrivateKey privateKey;
    @Getter
    protected String ownerInfo;
}