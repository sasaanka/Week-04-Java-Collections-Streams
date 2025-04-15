import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class TaskManager {
    public String longRunningTask() {
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        return "Task Completed";
    }
}
public class LongRunningTask {
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS) 
    public void testLongRunningTaskTimeout() {
        TaskManager manager = new TaskManager();
        manager.longRunningTask(); 
    }
}
