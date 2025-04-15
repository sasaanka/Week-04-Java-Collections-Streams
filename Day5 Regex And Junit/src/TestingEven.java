import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Even {
	public boolean isEven(int num) {
		if(num%2==0) {
			return true;
		}
		return false;
	}
}
public class TestingEven{
	private Even evn;
	@BeforeEach
	public void setup() {
		evn=new Even();
	}
	@Test
	public void testisEven() {
		assertTrue(evn.isEven(10),"10 is even");
		assertTrue(evn.isEven(16),"16 is even");
		assertFalse(evn.isEven(15),"15 is odd");
	}
}
