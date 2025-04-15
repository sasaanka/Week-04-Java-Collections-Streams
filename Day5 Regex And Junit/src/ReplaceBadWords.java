import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class ReplaceBadWords {
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.print("Enter the text: ");
		String text=inp.nextLine();
		List<String> badwords=Arrays.asList("damn","Stupid","idiot");
		for (String word: badwords) {
			text=text.replaceAll("(?i)\\b"+word+"\\b","*****");
		}
		System.out.println("Censored sentence: " + text);
        inp.close();
	}
}
