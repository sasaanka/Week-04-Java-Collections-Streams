import java.util.Scanner;
public class NestedtryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {5, 10, 15, 20, 25};
        try {
            System.out.print("Enter the index to access: ");
            int index = scanner.nextInt();
            try {
                int value = numbers[index];
                System.out.print("Enter the divisor: ");
                int divisor = scanner.nextInt();
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        } finally {
            scanner.close();
            System.out.println("Program ended.");
        }
    }
}
