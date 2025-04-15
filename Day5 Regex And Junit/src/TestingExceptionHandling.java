import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Calculator {
	public int divide(int a,int b) {
		if(b==0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		return a/b;
	}
}
public class TestingExceptionHandling{
	@Test
    public void testDivideByZeroThrowsException() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
    @Test
    public void testValidDivision() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.divide(10, 2));
    }
}
