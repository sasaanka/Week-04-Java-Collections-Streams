import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class Stringfunction{
	public  String reverse(String str) {
		String result="";
		for(int i=str.length()-1;i>=0;i--) {
			result=result+str.charAt(i);
		}
		return result;
	}
	public boolean isPalindrome(String str) {
		boolean ispal=false;
		String result="";
		for(int i=str.length()-1;i>=0;i--) {
			result=result+str.charAt(i);
		}
		if(str.equals(result)) {
			System.out.print("Palindrome");
			return true;
		}else {
			System.out.println("Not  a palindrome");
			return false;
		}
	}
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
public class StringTest{
	private Stringfunction fun;
	@BeforeEach
	public void setup() {
		fun=new Stringfunction();
	}
	@Test
	public void testReverse() {
		assertEquals("avaj",fun.reverse("java"),"Reverse of java is avaj");
		assertEquals("nohtyp",fun.reverse("python"),"Reverse of python is nohtyp");
	}
	@Test
	public void testPalindrome() {
		assertTrue(fun.isPalindrome("racecar"),"racecar is a palindrome");
		assertFalse(fun.isPalindrome("java"),"java is not a palindrome");
	}
	@Test
	public void testupper() {
		assertEquals("JAVA",fun.toUpperCase("java"),"Java is changed to Uppercase");
		assertEquals("PYTHON",fun.toUpperCase("python"),"python is changed to Uppercase");
	}
}
