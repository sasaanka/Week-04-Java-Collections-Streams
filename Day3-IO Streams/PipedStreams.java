import java.io.*;
public class PipedStreams {
    public static void main(String[] args) {
        try {
            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream(outputStream);
            Thread writerThread = new Thread(new WriterTask(outputStream));
            Thread readerThread = new Thread(new ReaderTask(inputStream));
            writerThread.start();
            readerThread.start();
        } catch (IOException e) {
            System.err.println("IOException while setting up streams: " + e.getMessage());
        }
    }
}
class WriterTask implements Runnable {
    private PipedOutputStream outputStream;

    public WriterTask(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }
    @Override
    public void run() {
        try (PipedOutputStream out = outputStream) {
            String message = "Hello from Writer Thread";
            out.write(message.getBytes());
            out.flush();
            System.out.println("Writer Message is sent.");
        } catch (IOException e) {
            System.err.println("IOException in WriterTask: " + e.getMessage());
        }
    }
}
class ReaderTask implements Runnable {
    private PipedInputStream inputStream;

    public ReaderTask(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try (PipedInputStream in = inputStream) {
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String receivedMessage = new String(buffer, 0, bytesRead);
            System.out.println("Reader received message is -> " + receivedMessage);
        } catch (IOException e) {
            System.err.println("IOException in ReaderTask: " + e.getMessage());
        }
    }
}
