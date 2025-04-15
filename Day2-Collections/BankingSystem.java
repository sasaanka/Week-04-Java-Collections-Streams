import java.util.*;
 class Account {
    private final String accountNumber;
    private double balance;
    public Account(String acct, double initialBalance) {
        this.accountNumber = acct;
        this.balance = initialBalance;
    }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance()         { return balance; }
    public double withdraw(double amount) {
        double withdrawn = Math.min(amount, balance);
        balance -= withdrawn;
        return withdrawn;
    }
}
 class WithdrawalRequest {
    public final String accountNumber;
    public final double amount;
    public WithdrawalRequest(String acct, double amt) {
        this.accountNumber = acct;
        this.amount = amt;
    }
}
public class BankingSystem {
    private final Map<String, Account> accounts = new HashMap<>();
    private final NavigableMap<Double, List<Account>> balanceIndex = new TreeMap<>();
    private final Queue<WithdrawalRequest> queue = new LinkedList<>();
    public void addAccount(String acctNum, double initialBalance) {
        Account acct = new Account(acctNum, initialBalance);
        accounts.put(acctNum, acct);
        indexAccount(acct);
    }
    private void indexAccount(Account acct) {
        balanceIndex.computeIfAbsent(acct.getBalance(), b -> new ArrayList<>()).add(acct);
    }
    public void requestWithdrawal(String acctNum, double amount) {
        queue.add(new WithdrawalRequest(acctNum, amount));
    }
    public void processWithdrawals() {
        while (!queue.isEmpty()) {
            WithdrawalRequest req = queue.remove();
            Account acct = accounts.get(req.accountNumber);
            if (acct == null) {
                System.out.println("No such account: " + req.accountNumber);
                continue;
            }
            balanceIndex.get(acct.getBalance()).remove(acct);
            double withdrawn = acct.withdraw(req.amount);
            System.out.printf("Withdrew %.2f from %s, new balance: %.2f%n",withdrawn, acct.getAccountNumber(), acct.getBalance());
            indexAccount(acct);
        }
    }
    public void printAccountsByBalance() {
        for (var entry : balanceIndex.entrySet()) {
            for (Account acct : entry.getValue()) {
                System.out.printf("%s → %.2f%n",acct.getAccountNumber(), acct.getBalance());
            }
        }
    }
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("A100", 500.0);
        bank.addAccount("B200", 300.0);
        bank.addAccount("C300", 800.0);
        bank.requestWithdrawal("B200", 50);
        bank.requestWithdrawal("A100", 600);
        bank.processWithdrawals();
        System.out.println("\nAccounts sorted by balance:");
        bank.printAccountsByBalance();
    }
}
