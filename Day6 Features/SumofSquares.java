import java.util.Arrays;
import java.util.List;
public class SumofSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        int sumOfSquares = numbers.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * n)
        .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
