import java.util.Scanner;
import java.util.regex.*;
public class ExtractDates {
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter the date: ");
		String text=inp.nextLine();
		String regex="\\b\\d{2}/\\d{2}/\\d{4}\\b";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Found dates:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
        inp.close();
	}
}
