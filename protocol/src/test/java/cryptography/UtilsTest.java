package cryptography;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public class UtilsTest{

    @Test
    public void encryptDecryptTest() {
        String password = "32412345";
        String info = "Test information";

        byte[] encryptedData = Utils.encrypt(password, info.getBytes());
        byte[] decryptedData = Utils.decrypt(password, encryptedData);

        String recievedData = new String(decryptedData);
        Assert.assertEquals(info, recievedData);
    }
}