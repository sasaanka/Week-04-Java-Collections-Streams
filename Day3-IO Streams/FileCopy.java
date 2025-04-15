import java.io.*;
public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File source = new File(sourceFile);
            if (!source.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }
            fis = new FileInputStream(source);
            fos = new FileOutputStream(destinationFile);
            
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
            System.out.println("File has been copied successfully!");
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
