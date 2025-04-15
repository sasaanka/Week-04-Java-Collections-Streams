import java.util.Scanner;
import java.util.regex.*;
public class CaptialWords {
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter a Sentence: ");
		String text=inp.nextLine();
		String regex="\b[A-Z][a-zA-Z]*\b";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Found capitalized words:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
        inp.close();
	}
}
