import java.util.*;
public class FrequencyofWords{
    public static void main(String[] args) {
        List<String> items=Arrays.asList("Apple","Banana","Apple","Orange");
        HashMap<String,Integer> fremap=getfrequnecy(items);
        System.out.println("Frequency map: "+fremap);
    }
    public static HashMap<String,Integer> getfrequnecy(List<String> items){
        HashMap<String, Integer> map = new HashMap<>();
    for (String item : items) {
        if (map.containsKey(item)) {
            int count = map.get(item);
            map.put(item, count + 1);
        } else {
            map.put(item, 1);
        }
    }
    return map;
    }
}