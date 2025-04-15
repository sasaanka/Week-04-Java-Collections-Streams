import java.util.Scanner;
import java.util.regex.*;
public class Emailfromtext {
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter a text: ");
		String text=inp.nextLine();
		String regex="\\b[a-zA-Z0-9._+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Found email addresses:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        inp.close();
	}
}
	
