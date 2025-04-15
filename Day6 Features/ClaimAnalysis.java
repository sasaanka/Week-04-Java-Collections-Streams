import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
public class ClaimAnalysis {
    static class Claim {
        final private String claimId;
        final private String policyNumber;
        final private double claimAmount;
        final private LocalDate claimDate;
        final private String status;

        public Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }
        public String getClaimId() {
             return claimId; 
        }
        public String getPolicyNumber() { 
            return policyNumber; 
        }
        public double getClaimAmount() { 
            return claimAmount; 
        }
        public LocalDate getClaimDate() { 
            return claimDate; 
        }
        public String getStatus() { 
            return status; 
        }
    }
    static class PolicyStats {
        final private String policyNumber;
        final private double totalClaimAmount;
        final private double averageClaimAmount;

        public PolicyStats(String policyNumber, double totalClaimAmount, double averageClaimAmount) {
            this.policyNumber = policyNumber;
            this.totalClaimAmount = totalClaimAmount;
            this.averageClaimAmount = averageClaimAmount;
        }

        public double getTotalClaimAmount() {
            return totalClaimAmount;
        }

        @Override
        public String toString() {
            return "Policy: " + policyNumber + ", Total Claim Amount: $" + totalClaimAmount + ", Average Claim Amount: $" + String.format("%.2f", averageClaimAmount);
        }
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C101", "P1001", 8000, LocalDate.of(2023, 3, 12), "Approved"),
            new Claim("C102", "P1002", 4000, LocalDate.of(2023, 4, 18), "Approved"),
            new Claim("C103", "P1001", 6000, LocalDate.of(2023, 5, 2), "Approved"),
            new Claim("C104", "P1003", 7000, LocalDate.of(2023, 6, 20), "Rejected"),
            new Claim("C105", "P1002", 9500, LocalDate.of(2023, 7, 1), "Approved"),
            new Claim("C106", "P1003", 12000, LocalDate.of(2023, 8, 15), "Approved"),
            new Claim("C107", "P1003", 1500, LocalDate.of(2023, 9, 9), "Approved")
        );

        List<Claim> filteredClaims = claims.stream()
            .filter(c -> c.getStatus().equalsIgnoreCase("Approved") && c.getClaimAmount() > 5000)
            .collect(Collectors.toList());

        Map<String, List<Claim>> groupedByPolicy = filteredClaims.stream()
            .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<PolicyStats> statsList = groupedByPolicy.entrySet().stream()
            .map(entry -> {
                String policy = entry.getKey();
                List<Claim> claimList = entry.getValue();
                double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                double avg = claimList.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0);
                return new PolicyStats(policy, total, avg);
            })
            .collect(Collectors.toList());

        List<PolicyStats> top3 = statsList.stream()
            .sorted(Comparator.comparingDouble(PolicyStats::getTotalClaimAmount).reversed())
            .limit(3)
            .collect(Collectors.toList());

        System.out.println("Top 3 Policies by Total Claim Amount:");
        top3.forEach(System.out::println);
    }
}
