import java.util.Scanner;
import java.util.function.BiFunction;

public class Concat{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        BiFunction<String, String, String> concatenateWithSpace = (s1, s2) -> s1 + " " + s2;
        String result = concatenateWithSpace.apply(str1, str2);
        System.out.println("Concatenated String: " + result);
    }
}
