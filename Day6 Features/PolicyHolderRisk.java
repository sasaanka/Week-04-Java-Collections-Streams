import java.util.*;
import java.util.stream.*;

public class PolicyHolderRisk {
    static class PolicyHolder {
        final private String holderId;
        final private String name;
        final private int age;
        final private String policyType;
        final private double premiumAmount;
        public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }
        public String getHolderId() { return holderId; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getPolicyType() { return policyType; }
        public double getPremiumAmount() { return premiumAmount; }
    }

    static class RiskAssessment {
        final private String holderId;
        final private String name;
        final private double riskScore;

        public RiskAssessment(String holderId, String name, double riskScore) {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
        }
        public double getRiskScore() {
            return riskScore;
        }
        public String getRiskCategory() {
            return riskScore > 0.5 ? "High Risk" : "Low Risk";
        }
        @Override
        public String toString() {
            return holderId + " - " + name + " | Risk Score: " + String.format("%.2f", riskScore)+ " | Category: " + getRiskCategory();
        }
    }

    public static void main(String[] args) {
        List<PolicyHolder> policyHolders = Arrays.asList(
            new PolicyHolder("H101", "Sasanka", 65, "Health", 400.0),
            new PolicyHolder("H102", "Bharath", 70, "Life", 300.0),
            new PolicyHolder("H103", "Abhinaya", 68, "Health", 600.0),
            new PolicyHolder("H104", "Shasank", 72, "Life", 500.0),
            new PolicyHolder("H105", "Hemateja", 59, "Life", 700.0),
            new PolicyHolder("H106", "Sana", 66, "Health", 200.0),
            new PolicyHolder("H107", "Samaya", 75, "Life", 420.0)
        );
        List<PolicyHolder> filtered = policyHolders.stream()
            .filter(p -> p.getPolicyType().equalsIgnoreCase("Life") && p.getAge() > 60)
            .collect(Collectors.toList());

        List<RiskAssessment> riskAssessments = filtered.stream()
            .map(p -> new RiskAssessment(
                p.getHolderId(),
                p.getName(),
                p.getPremiumAmount() / p.getAge()))
            .collect(Collectors.toList());

        List<RiskAssessment> sorted = riskAssessments.stream()
            .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
            .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorized = sorted.stream()
            .collect(Collectors.groupingBy(RiskAssessment::getRiskCategory));

        System.out.println("Risk Assessment Results:");
        categorized.forEach((category, assessments) -> {
            System.out.println("\n" + category + ":");
            assessments.forEach(System.out::println);
        });
    }
}
