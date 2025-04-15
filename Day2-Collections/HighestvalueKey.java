import java.util.*;
import java.util.Map.Entry;
public class HighestvalueKey{
    public static String keyWithMaxValue(Map<String,Integer> input){
    if(input==null || input.isEmpty()){
        System.err.println("List cannot be empty");
    }
    String maxkey = null;
    int maxvalue = Integer.MIN_VALUE;
    for (Entry<String, Integer> entry : input.entrySet()) {
        if (entry.getValue() > maxvalue) {
            maxvalue = entry.getValue();
            maxkey   = entry.getKey();
        }
    }
    return maxkey;
}
    public static void main(String[] args) {
        Map<String,Integer> input=new HashMap<>(Map.of("A",10,"B",20,"C",15));
        System.out.println("MAx value: "+keyWithMaxValue(input));
    }
}