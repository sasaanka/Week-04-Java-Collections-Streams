import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringFiltering{
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "grapefruit", "mango", "pineapple", "kiwi");
        String substr = "ap"; 
        Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;
        Predicate<String> containsSubstring = s -> s.contains(substr);
        Predicate<String> combinedPredicate = lengthGreaterThan5.and(containsSubstring);
        List<String> filteredWords = words.stream()
            .filter(combinedPredicate)
            .collect(Collectors.toList());
        System.out.println("Filtered words: " + filteredWords);
    }
}
