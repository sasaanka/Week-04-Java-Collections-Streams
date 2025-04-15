import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class InsurancePolicy implements Comparable<InsurancePolicy> {
    String policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsurancePolicy)) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return policyNumber.equals(that.policyNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, %.2f]",
                policyNumber, policyHolderName, expiryDate, coverageType, premiumAmount);
    }
}

// Manager class
public class InsurancePolicyManager {
    Set<InsurancePolicy> hashSet = new HashSet<>();
    Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    Set<InsurancePolicy> treeSet = new TreeSet<>();
    void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    void displayAll(Set<InsurancePolicy> set) {
        for (InsurancePolicy policy : set) {
            System.out.println(policy);
        }
    }
    void displayExpiringSoon(Set<InsurancePolicy> set) {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);
        for (InsurancePolicy policy : set) {
            if (!policy.expiryDate.isBefore(now) && !policy.expiryDate.isAfter(limit)) {
                System.out.println(policy);
            }
        }
    }
    void displayByCoverageType(Set<InsurancePolicy> set, String type) {
        for (InsurancePolicy policy : set) {
            if (policy.coverageType.equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }
    void findDuplicates(List<InsurancePolicy> policyList) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (InsurancePolicy policy : policyList) {
            if (!seen.add(policy.policyNumber)) {
                duplicates.add(policy.policyNumber);
            }
        }
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate Policy Numbers: " + duplicates);
        }
    }

    public void testPerformance() {
        final int SIZE = 100000;
        Random rand = new Random();
        @SuppressWarnings("unused")
        Set<InsurancePolicy> hs = new HashSet<>();
        Set<InsurancePolicy> lhs = new LinkedHashSet<>();
        Set<InsurancePolicy> ts = new TreeSet<>();
        System.out.println("Performance Test with " + SIZE + " elements:");
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            hs.add(new InsurancePolicy("P" + i, "Name" + i, LocalDate.now().plusDays(rand.nextInt(365)),"Health", rand.nextInt(10000)));
        }
        long end = System.currentTimeMillis();
        System.out.println("HashSet Add: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            lhs.add(new InsurancePolicy("P" + i, "Name" + i, LocalDate.now().plusDays(rand.nextInt(365)),"Auto", rand.nextInt(10000)));
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedHashSet Add: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            ts.add(new InsurancePolicy("P" + i, "Name" + i, LocalDate.now().plusDays(rand.nextInt(365)),"Home", rand.nextInt(10000)));
        }
        end = System.currentTimeMillis();
        System.out.println("TreeSet Add: " + (end - start) + "ms");
        InsurancePolicy searchPolicy = new InsurancePolicy("P99999", "Dummy", LocalDate.now(), "Health", 0);
        start = System.currentTimeMillis();
        hs.contains(searchPolicy);
        end = System.currentTimeMillis();
        System.out.println("HashSet Search: " + (end - start) + "ms");
        start = System.currentTimeMillis();
        lhs.contains(searchPolicy);
        end = System.currentTimeMillis();
        System.out.println("LinkedHashSet Search: " + (end - start) + "ms");
        start = System.currentTimeMillis();
        ts.contains(searchPolicy);
        end = System.currentTimeMillis();
        System.out.println("TreeSet Search: " + (end - start) + "ms");
        System.out.println("HashSet Size: " + hs.size());
        System.out.println("LinkedHashSet Size: " + lhs.size());
        System.out.println("TreeSet Size: " + ts.size());

    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        InsurancePolicy p1 = new InsurancePolicy("P1001", "Alice", LocalDate.parse("2025-05-15", formatter), "Health", 5000);
        InsurancePolicy p2 = new InsurancePolicy("P1002", "Bob", LocalDate.parse("2025-04-30", formatter), "Auto", 3000);
        InsurancePolicy p3 = new InsurancePolicy("P1003", "Charlie", LocalDate.parse("2025-04-20", formatter), "Home", 4500);
        InsurancePolicy p4 = new InsurancePolicy("P1002", "Bob Duplicate", LocalDate.parse("2025-04-30", formatter), "Auto", 3000);
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4); 

        System.out.println("\nAll Unique Policies (LinkedHashSet - insertion order):");
        manager.displayAll(manager.linkedHashSet);
        System.out.println("\nPolicies Expiring Within 30 Days (TreeSet - sorted by expiry date):");
        manager.displayExpiringSoon(manager.treeSet);
        System.out.println("\nPolicies with 'Auto' Coverage:");
        manager.displayByCoverageType(manager.hashSet, "Auto");
        System.out.println("\nDuplicate Detection from List:");
        manager.findDuplicates(Arrays.asList(p1, p2, p3, p4));
        System.out.println("\n--- Performance Comparison ---");
        manager.testPerformance();
    }
}
