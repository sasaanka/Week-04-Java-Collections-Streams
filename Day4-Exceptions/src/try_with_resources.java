import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class try_with_resources {
    public static void main(String[] args) {
        String fileName = "src/data.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        System.out.println("Program ended.");
    }
}
