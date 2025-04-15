import java.util.Scanner;
import java.util.regex.*;
public class LicensePlate {
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter a License plate number: ");
		String num=inp.nextLine();
		String regex="^[A-Z]{2}[0-9]{4}$";
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(num);
		if(match.matches()) {
			System.out.println(num+" is valid ");
		}else {
			System.out.println(num+" is not  valid ");
		}
		inp.close();
	}
}
