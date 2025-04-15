import java.util.Scanner;
import java.util.regex.*;
import java.util.HashSet;
import java.util.Set;
public class RepeatedWords {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = inp.nextLine();
        String regex = "\\b(\\w+)\\s+\\1\\b";      
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        Set<String> repeatingWords = new HashSet<>();        
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }
        if (repeatingWords.isEmpty()) {
            System.out.println("No repeating words found.");
        } else {
            System.out.println("Repeating words: " + String.join(", ", repeatingWords));
        }    
        inp.close();
    }
}
