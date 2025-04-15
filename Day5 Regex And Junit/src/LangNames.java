import java.util.Scanner;
import java.util.regex.*;
import java.util.Arrays;
public class LangNames {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the sentence: " );
		String text=input.nextLine();
		String regex="\\b(?i)(Java|python|Go|JavaScript)\\b";
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(text);
		System.out.println("Found programming languges are: ");
		while(match.find()) {
			System.out.print(match.group()+" , ");
		}
		input.close();
	}
}
