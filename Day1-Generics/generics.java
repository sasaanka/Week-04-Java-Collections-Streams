import java.util.*;

public class generics {

    // Generic method with extra parameter (no bounds)
    public static <T> void displaySwap(T i, T j, int extra) {
        T temp = i;
        i = j;
        j = temp;
        System.out.println("After swapping: " + i + " , " + j + " , Extra: " + extra);
    }

    // Upper bound wildcard: reading numbers
    public static void printNumbers(List<? extends Number> numbers) {
        System.out.println("Printing numbers:");
        for (Number n : numbers) {
            System.out.println(n);
        }
    }

    // Lower bound wildcard: writing integers
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);    
        list.add(100);  
        System.out.println("After adding: " + list);
    }

    // Generic class
    public static class Flight<T> {
        private final T flightNumber;

        public Flight(T flightNumber) {
            this.flightNumber = flightNumber;
        }

        public T getFlightNumber() {
            return flightNumber;
        }
    }

    public static void main(String[] args) {
        // Generic method usage
        displaySwap("Poturi", "Sasanka", 23);
        displaySwap(45, 2, 45);
        displaySwap(true, false, 67);

        // Using generic class
        Flight<Integer> flight1 = new Flight<>(101);
        Flight<String> flight2 = new Flight<>("AA202");
        System.out.println("Flight 1 Number: " + flight1.getFlightNumber());
        System.out.println("Flight 2 Number: " + flight2.getFlightNumber());

        // Using wildcard examples
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3));
        printNumbers(intList);   // upper bound (reading)
        addNumbers(intList);     // lower bound (writing)
    }
}
