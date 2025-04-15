import java.util.Scanner;
public class ReplaceSpaces {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = inp.nextLine(); 
        String result = text.replaceAll("\\s{2,}", " ");      
        System.out.println("Output: " + result);
        inp.close();
    }
}
