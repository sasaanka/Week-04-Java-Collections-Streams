import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
public class FraudDetection {
    static class Transaction {
        final private String transactionId;
        final private String policyNumber;
        final private double amount;
        final private LocalDate transactionDate;
        final private boolean isFraudulent;
        public Transaction(String transactionId, String policyNumber, double amount, LocalDate transactionDate, boolean isFraudulent) {
            this.transactionId = transactionId;
            this.policyNumber = policyNumber;
            this.amount = amount;
            this.transactionDate = transactionDate;
            this.isFraudulent = isFraudulent;
        }
        public String getTransactionId() { return transactionId; }
        public String getPolicyNumber() { return policyNumber; }
        public double getAmount() { return amount; }
        public LocalDate getTransactionDate() { return transactionDate; }
        public boolean isFraudulent() { return isFraudulent; }
    }

    static class FraudReport {
        final private String policyNumber;
        final private long fraudCount;
        final private double totalFraudAmount;

        public FraudReport(String policyNumber, long fraudCount, double totalFraudAmount) {
            this.policyNumber = policyNumber;
            this.fraudCount = fraudCount;
            this.totalFraudAmount = totalFraudAmount;
        }

        public boolean isAlertNeeded() {
            return fraudCount > 5 || totalFraudAmount > 50000;
        }
        @Override
        public String toString() {
            return "ALERT - Policy: " + policyNumber +" , Fraudulent Transactions: " + fraudCount + " , Total Fraud Amount: $" + totalFraudAmount;
        }
    }
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T001", "P1001", 15000, LocalDate.of(2024, 1, 10), true),
            new Transaction("T002", "P1001", 20000, LocalDate.of(2024, 2, 15), true),
            new Transaction("T003", "P1001", 18000, LocalDate.of(2024, 3, 20), true),
            new Transaction("T004", "P1001", 17000, LocalDate.of(2024, 4, 25), true),
            new Transaction("T005", "P1001", 21000, LocalDate.of(2024, 5, 10), true),
            new Transaction("T007", "P1002", 30000, LocalDate.of(2024, 1, 12), true),
            new Transaction("T008", "P1002", 26000, LocalDate.of(2024, 2, 19), true),
            new Transaction("T009", "P1003", 9500, LocalDate.of(2024, 3, 15), true),
            new Transaction("T010", "P1004", 40000, LocalDate.of(2024, 4, 5), false)
        );

        List<Transaction> filtered = transactions.stream()
            .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
            .collect(Collectors.toList());

        Map<String, List<Transaction>> groupedByPolicy = filtered.stream()
            .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        List<FraudReport> reports = groupedByPolicy.entrySet().stream()
            .map(entry -> {
                String policy = entry.getKey();
                List<Transaction> txList = entry.getValue();
                long count = txList.size();
                double totalAmount = txList.stream().mapToDouble(Transaction::getAmount).sum();
                return new FraudReport(policy, count, totalAmount);
            })
            .collect(Collectors.toList());

        System.out.println("Fraud Alerts:");
        reports.stream()
            .filter(FraudReport::isAlertNeeded)
            .forEach(System.out::println);
    }
}
