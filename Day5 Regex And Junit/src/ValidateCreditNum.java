import java.util.Scanner;
import java.util.regex.*;
public class ValidateCreditNum {
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter the credit card number: ");
		String num=inp.nextLine();
		String regex="^4\\d{15}$|^5\\d{15}";
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(num);
	    if (matcher.matches()) {
	         System.out.println(num + " is a valid credit card number.");
	    } else {
	         System.out.println(num + " is not a valid credit card number.");
	    }
	    inp.close();
	}
}
