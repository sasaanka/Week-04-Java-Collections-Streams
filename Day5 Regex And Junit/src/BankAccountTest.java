import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class BankAccount {
    private double balance;
    public BankAccount() {
        this.balance = 0.0;
    }
    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; 
        }
    }
    public double getBalance() {
        return balance;
    }
}
public class BankAccountTest {
    private BankAccount account;
    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }
    @Test
    public void testDepositIncreasesBalance() {
        account.deposit(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }
    @Test
    public void testWithdrawDecreasesBalance() {
        account.deposit(200.0);
        boolean result = account.withdraw(80.0);
        assertTrue(result);
        assertEquals(120.0, account.getBalance(), 0.001);
    }
    @Test
    public void testWithdrawFailsOnInsufficientFunds() {
        account.deposit(50.0);
        boolean result = account.withdraw(100.0);
        assertFalse(result);
        assertEquals(50.0, account.getBalance(), 0.001);
    }
    @Test
    public void testGetBalance() {
        assertEquals(0.0, account.getBalance(), 0.001);
        account.deposit(75.0);
        assertEquals(75.0, account.getBalance(), 0.001);
    }
}
