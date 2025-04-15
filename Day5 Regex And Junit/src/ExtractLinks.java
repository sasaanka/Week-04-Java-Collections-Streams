import java.util.Scanner;
import java.util.regex.*;
public class ExtractLinks {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the text: ");
		String text=input.nextLine();
		String regex="\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(text);
		System.out.println("Found link: ");
		while(matcher.find()) {
			System.out.print(matcher.group()+" , ");
		}
		input.close();
	}
}
