
package maven.maven;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Banktest {

    @Test
    public void testDeposit() {
        Bank bank = new Bank(5000);
        bank.deposit(2000);

        assertEquals(7000, bank.getBalance());
    }

    @Test
    public void testWithdraw() {
        Bank bank = new Bank(5000);
        bank.withdraw(1000);

        assertEquals(4000, bank.getBalance());
    }

    @Test
    public void testInsufficientBalance() {
        Bank bank = new Bank(1000);

        assertThrows(IllegalArgumentException.class,
                () -> bank.withdraw(2000));
    }

    @Test
    public void testZeroAndNegativeAmount() {
        Bank bank = new Bank(5000);

        assertThrows(IllegalArgumentException.class,
                () -> bank.deposit(0));

        assertThrows(IllegalArgumentException.class,
                () -> bank.deposit(-500));

        assertThrows(IllegalArgumentException.class,
                () -> bank.withdraw(-200));
    }

    @Test
    public void testMultipleTransactions() {
        Bank bank = new Bank(10000);

        bank.deposit(2000);
        bank.withdraw(3000);
        bank.deposit(1000);
        bank.withdraw(2000);

        assertEquals(8000, bank.getBalance());
    }

    @Test
    public void testInitialBalance() {
        Bank bank = new Bank(5000);

        assertEquals(5000, bank.getBalance());
    }

    @Test
    public void testInvalidInitialBalance() {
        assertThrows(IllegalArgumentException.class,
                () -> new Bank(-1000));
    }
}
