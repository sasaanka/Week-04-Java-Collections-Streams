import java.util.Scanner;
import java.util.regex.*;
public class CurrencyFromText {
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter the text: ");
		String text=inp.nextLine();
		String regex="(\\$?\\d+(\\.\\d{2})?)";
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(text);     
	    System.out.println("Found currency values:");
	    while (matcher.find()) {
	         System.out.print(matcher.group() + ", ");
	    }
	    inp.close();
	}
}
