import java.util.ArrayList;
import java.util.List;
public class Example {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("Fruits: " + fruits);
        System.out.println("Second fruit: " + fruits.get(1));
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);
    }
}
