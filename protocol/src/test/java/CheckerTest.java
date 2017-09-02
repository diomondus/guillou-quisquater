import card.CardGQ;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dmitry Butilov
 * on 02.09.17.
 */
public class CheckerTest {

    @Test
    public void testCryptography() {
        int N = 1024;
        CardGQ cardGQ = new CardGQ("", N);
        Checker checker = new Checker();
        Assert.assertTrue(checker.check(cardGQ));
    }
}