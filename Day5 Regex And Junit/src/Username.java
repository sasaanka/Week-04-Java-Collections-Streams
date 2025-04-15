import java.util.Scanner;
import java.util.regex.*;
public class Username {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a username: ");
		String user=input.nextLine();
		String regex ="^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(user);
		if(match.matches()) {
			System.out.println(user+" is valid ");
		}else {
			System.out.println(user+" is not  valid ");
		}
		input.close();
	}
}
