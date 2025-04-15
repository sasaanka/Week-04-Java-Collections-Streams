import java.io.*;
import java.util.Arrays;
public class ByteArrayStream {
	public static void main(String[] args) {
        String inputImagePath = "C:\\Users\\DELL\\lemon.jpeg";     
        String outputImagePath = "copied.jpg";      
        try {        
            byte[] imageBytes = readImageToByteArray(inputImagePath);
            writeByteArrayToImage(imageBytes, outputImagePath);
            boolean isIdentical = compareFiles(inputImagePath, outputImagePath);
            System.out.println("Both Files are identical: " + isIdentical);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
    public static byte[] readImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image written successfully to: " + outputPath);
        }
    }
    public static boolean compareFiles(String path1, String path2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(path1);
             FileInputStream fis2 = new FileInputStream(path2)) {
            byte[] file1Bytes = fis1.readAllBytes();
            byte[] file2Bytes = fis2.readAllBytes();
            return Arrays.equals(file1Bytes, file2Bytes);
        }
    }
}

