import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class InsurancePolicy {
    String policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate,String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, %.2f]",policyNumber, policyHolderName, expiryDate, coverageType, premiumAmount);
    }
}
public class InsurancePolicySystem {
    Map<String, InsurancePolicy> hashMap = new HashMap<>();
    Map<String, InsurancePolicy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<InsurancePolicy>> treeMap = new TreeMap<>();
     void addPolicy(InsurancePolicy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);

        treeMap.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }
    public void getPolicyByNumber(String policyNumber) {
        InsurancePolicy policy = hashMap.get(policyNumber);
        if (policy != null) {
            System.out.println("Found: " + policy);
        } else {
            System.out.println("Policy not found.");
        }
    }
    public void listExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);
        System.out.println("\nPolicies Expiring Within 30 Days:");
        treeMap.subMap(now, true, limit, true)
                .values().forEach(list -> list.forEach(System.out::println));
    }
    public void listByPolicyHolder(String name) {
        System.out.println("\nPolicies for " + name + ":");
        for (InsurancePolicy policy : hashMap.values()) {
            if (policy.policyHolderName.equalsIgnoreCase(name)) {
                System.out.println(policy);
            }
        }
    }
    public void removeExpired() {
        LocalDate now = LocalDate.now();
        Set<LocalDate> toRemove = new HashSet<>(treeMap.headMap(now, false).keySet());
        for (LocalDate date : toRemove) {
            for (InsurancePolicy policy : treeMap.get(date)) {
                hashMap.remove(policy.policyNumber);
                linkedHashMap.remove(policy.policyNumber);
            }
            treeMap.remove(date);
        }
        System.out.println("\nExpired policies removed.");
    }
    public void displayAllPolicies() {
        System.out.println("\nAll Policies (in insertion order):");
        for (InsurancePolicy policy : linkedHashMap.values()) {
            System.out.println(policy);
        }
    }
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        system.addPolicy(new InsurancePolicy("P101", "Sasanka", LocalDate.parse("2025-05-10", formatter), "Health", 5000));
        system.addPolicy(new InsurancePolicy("P102", "Bharath", LocalDate.parse("2025-04-27", formatter), "Auto", 3500));
        system.addPolicy(new InsurancePolicy("P103", "Abhi", LocalDate.parse("2025-04-20", formatter), "Home", 4000));
        system.addPolicy(new InsurancePolicy("P104", "Shasank", LocalDate.parse("2025-06-15", formatter), "Health", 4500));

        system.displayAllPolicies();
        system.getPolicyByNumber("P102");
        system.listExpiringSoon();
        system.listByPolicyHolder("Sasanka");
        system.removeExpired();
        system.displayAllPolicies();
    }
}
