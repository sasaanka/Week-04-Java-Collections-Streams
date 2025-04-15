import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class ListOperations {
	public void addElement(List<Integer> list,int element) {
		list.add(element);
	}
	public void removeElement(List<Integer> list,int element) {
		list.remove(Integer.valueOf(element));
	}
	public int getsize(List<Integer> list) {
		return list.size();
	}
}
public class TestingListOperations{
	private ListOperations oper;
	private List<Integer> list;
	@BeforeEach
	public void setup() {
		oper=new ListOperations();
		list=new ArrayList<>();
	}
	@Test
	public void testAddElement() {
		oper.addElement(list,10);
		oper.addElement(list, 15);
		oper.addElement(list, 42);
		assertTrue(list.contains(15));
		assertTrue(list.contains(42));
		assertFalse(list.contains(48));
		assertEquals(3,list.size());
	}
	@Test
	public void testRemoveElement() {
		list.add(20);
		list.add(78);
		oper.removeElement(list, 20);
		assertTrue(list.contains(78));
		assertFalse(list.contains(20));
		assertEquals(1,list.size());
	}
	@Test
	public void testGetSize() {
		list.add(65);
		list.add(200);
		list.add(41);
		list.add(26);
		assertEquals(4,list.size());
	}
}
