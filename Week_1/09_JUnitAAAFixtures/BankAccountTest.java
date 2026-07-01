import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(100.0);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testDeposit() {
        double depositAmount = 50.0;
        double expectedBalance = 150.0;

        account.deposit(depositAmount);

        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        double withdrawAmount = 30.0;
        double expectedBalance = 70.0;

        account.withdraw(withdrawAmount);

        assertEquals(expectedBalance, account.getBalance(), 0.001);
    }
}
