import java.util.*;
public class WordFreqCount{
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
    public static void main(String[] args) {
        List<String> list=new LinkedList<>();
        list.add("Hello");
        list.add("World");
        list.add("Hello");
        list.add("Java");
        list.add("Sasanka");
        HashMap<String,Integer> fremap=getfrequnecy(list);
        System.out.println("Frequency map: "+fremap);
    }
}