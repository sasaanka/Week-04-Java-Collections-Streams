import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class InsurancePolicy {
    final private String policyNumber;
    final private String holderName;
    final private double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", HolderName: " + holderName + ", Premium: $" + premiumAmount;
    }
}

public class InsuranceApp {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P001", "Sasanka", 1100),
            new InsurancePolicy("P002", "Bharath", 1800),
            new InsurancePolicy("P003", "Abhinaya", 2200),
            new InsurancePolicy("P004", "Sara", 950),
            new InsurancePolicy("P005", "Arjun", 2000),
            new InsurancePolicy("P006", "Abhilash", 1500)
        );

        System.out.println("Premium > $1200:");
        policies.stream().filter(p -> p.getPremiumAmount() > 1200).forEach(System.out::println);

        System.out.println("\nSorted by Holder Name:");
        policies.stream().sorted(Comparator.comparing(InsurancePolicy::getHolderName)).forEach(System.out::println);

        double total = policies.stream().mapToDouble(InsurancePolicy::getPremiumAmount).sum();
        System.out.println("\nTotal Premium: $" + total);

        System.out.println("\nPolicy Details:");
        policies.forEach(System.out::println);

        System.out.println("\nPremium between $1000 and $2000:");
        policies.stream().filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .forEach(System.out::println);

        System.out.println("\nPolicy with Highest Premium:");
        policies.stream().max(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
                .ifPresent(System.out::println);

        System.out.println("\nGroup by Holder Name Initial:");
        Map<Character, List<InsurancePolicy>> grouped = policies.stream()
            .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));
        grouped.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        double avg = policies.stream().mapToDouble(InsurancePolicy::getPremiumAmount).average().orElse(0);
        System.out.println("\nAverage Premium: $" + avg);

        System.out.println("\nSorted by Premium (ascending):");
        policies.stream().sorted(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
                .forEach(System.out::println);

        boolean anyHigh = policies.stream().anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("\nAny premium > $2000? " + anyHigh);

        System.out.println("\nCount Policies by Premium Range:");
        long low = policies.stream().filter(p -> p.getPremiumAmount() <= 1000).count();
        long mid = policies.stream().filter(p -> p.getPremiumAmount() > 1000 && p.getPremiumAmount() <= 2000).count();
        long high = policies.stream().filter(p -> p.getPremiumAmount() > 2000).count();
        System.out.println("$0 - $1000: " + low);
        System.out.println("$1001 - $2000: " + mid);
        System.out.println(">$2000: " + high);

        System.out.println("\nUnique Holder Names:");
        policies.stream().map(InsurancePolicy::getHolderName).distinct().forEach(System.out::println);

        System.out.println("\nPolicies with Holder Name containing 'Smith':");
        policies.stream().filter(p -> p.getHolderName().contains("Smith")).forEach(System.out::println);

        System.out.println("\nMap<PolicyNumber, PremiumAmount>:");
        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(InsurancePolicy::getPolicyNumber, InsurancePolicy::getPremiumAmount));
        policyMap.forEach((k, v) -> System.out.println(k + " -> $" + v));

        System.out.println("\nTop N Frequent Words:");
        String text = "Java stream API helps in functional programming. Java is powerful. Stream and Lambda make Java elegant.";
        int topN = 3;
        Arrays.stream(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(topN)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        System.out.println("\nSecond Most Repeated Word:");
        List<Map.Entry<String, Long>> wordFreq = Arrays.stream(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        if (wordFreq.size() > 1)
            System.out.println("Second most frequent: " + wordFreq.get(1).getKey() + " - " + wordFreq.get(1).getValue());
        else
            System.out.println("Not enough data for second most frequent word.");
    }
}
