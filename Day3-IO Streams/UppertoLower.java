import java.io.*;
public class UppertoLower {
    public static void main(String[] args) {
        String inputFile = "source.txt";  
        String outputFile = "copy.txt"; 
        try {
            String content = readFile(inputFile);
            String lowerCaseContent = content.toLowerCase();
            writeFile(outputFile, lowerCaseContent);
            System.out.println("File conversion successful: From Uppercase to Lowercase");

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator()); 
            }
        }
        return content.toString();
    }
    public static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
}
