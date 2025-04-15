import java.util.HashMap;
import java.util.Map;
public class Mergemaps{
    public static Map<String,Integer> mergendsum(Map<String,Integer> map1,Map<String,Integer> map2){
        Map<String,Integer> result=new HashMap<>(map1);
        for(Map.Entry<String,Integer>e: map2.entrySet()){
            result.merge(e.getKey(), e.getValue(), Integer::sum);
        }
        return result;
    }
    public static void main(String[] args) {
        Map<String,Integer> map1=Map.of("A",1,"B",2);
        Map<String,Integer> map2=Map.of("B",3,"C",4);
        Map<String,Integer> merged=mergendsum(map1, map2);
        System.out.println("Merged map: "+merged);
    }
}