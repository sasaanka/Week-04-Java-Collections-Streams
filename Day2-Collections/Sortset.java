import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Sortset{
    public static void main(String[] args) {
        Set<Integer> list1=new HashSet<>(Set.of(5,7,9,1,10));
        List<Integer> sorted=new ArrayList<>();
        Collections.sort(sorted);
        System.out.println("List: "+list1);
    }
}