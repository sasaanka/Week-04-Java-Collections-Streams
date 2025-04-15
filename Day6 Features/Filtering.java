import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Filtering{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot");
        List<String> filtered = names.stream()
        .filter(s -> !s.startsWith("A"))
        .collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
    }
}
