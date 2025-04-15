import java.util.Scanner;
import java.util.regex.*;
public class HexColour {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("ENter the colur code: ");
		String code=input.nextLine();
		String regex="^[#][0-9A-Fa-f]{6}$";
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(code);
		if(match.matches()) {
			System.out.println(code+" is valid ");
		}else {
			System.out.println(code+" is not  valid ");
		}
		input.close();
	}
}
