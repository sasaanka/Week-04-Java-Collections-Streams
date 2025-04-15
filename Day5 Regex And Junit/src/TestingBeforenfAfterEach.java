import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class DatabaseConnection {
	private boolean connected=false;
	public void connect() {
		connected=true;
		System.out.println("Database connected");
	}
	public void disconnect() {
		connected=false;
		System.out.println("Database disconnected");
	}
	public boolean isConnected() {
		return connected;
	}
}
public class TestingBeforenfAfterEach{
	private DatabaseConnection connection;
	@BeforeEach
	public void setup() {
		connection=new DatabaseConnection();
		connection.connect();
	}
	@AfterEach
	public void teardown() {
		connection.disconnect();
	}
	@Test
	public void testconnection() {
		assertTrue(connection.isConnected(),"Database should be connected ");
	}
	@Test
	public void testconnectedClosed() {
		connection.disconnect();
		assertFalse(connection.isConnected(), "Database should be disconnected after calling disconnect.");
	}
}
