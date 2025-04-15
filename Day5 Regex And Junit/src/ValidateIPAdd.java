import java.util.Scanner;
import java.util.regex.*;
public class ValidateIPAdd {
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter the IP address: ");
		String address=inp.nextLine();
		String regex="^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(address);
		if(match.matches()) {
			System.out.println(address+" is valid ");
		}else {
			System.out.println(address+" is not  valid ");
		}
		inp.close();
	}
}
