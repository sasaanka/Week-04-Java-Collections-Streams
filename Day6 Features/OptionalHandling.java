import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class OptionalHandling{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> maxValue = numbers.stream().max(Integer::compareTo);
        maxValue.ifPresentOrElse(
            val -> System.out.println("Maximum value: " + val),
            () -> System.out.println("List is empty. No maximum value.")
        );
    }
}
