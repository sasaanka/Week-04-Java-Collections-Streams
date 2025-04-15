import java.io.*;
public class BufferedStream{
    public static void main(String[] args) {
        String sourcePath = "source.txt";            
        String bufferedDestPath = "copy.txt";
        String unbufferedDestPath = "copy.txt";
        int bufferSize = 4096; 
        long startBuffered = System.nanoTime();
        copyFileBuffered(sourcePath, bufferedDestPath, bufferSize);
        long endBuffered = System.nanoTime();
        long timeBuffered = endBuffered - startBuffered;
        long startUnbuffered = System.nanoTime();
        copyFileUnbuffered(sourcePath, unbufferedDestPath, bufferSize);
        long endUnbuffered = System.nanoTime();
        long timeUnbuffered = endUnbuffered - startUnbuffered;
        System.out.println("Buffered copy time:   " + timeBuffered / 1_000_000 + " ms");
        System.out.println("Unbuffered copy time: " + timeUnbuffered / 1_000_000 + " ms");
    }
    public static void copyFileBuffered(String source, String destination, int bufferSize) {
        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))
        ) {
            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Buffered Copy Error: " + e.getMessage());
        }
    }
    public static void copyFileUnbuffered(String source, String destination, int bufferSize) {
        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)
        ) {
            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Unbuffered Copy Error: " + e.getMessage());
        }
    }
}
