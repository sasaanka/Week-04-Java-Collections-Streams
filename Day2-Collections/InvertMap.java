import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class InvertMap{
    public static <K,V> Map<V, List<K>> invert(Map<K, V> original) {
        Map<V, List<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : original.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            inverted.computeIfAbsent(value, v -> new ArrayList<>()).add(key);
        }
        return inverted;
    }
     public static void main(String[] args) {
        Map<String, Integer> input = Map.of(
            "A", 1,
            "B", 2,
            "C", 1
        );
        Map<Integer, List<String>> output = invert(input);
        System.out.println("Inverted map: " + output);
    }
}