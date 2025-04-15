import java.util.HashSet;
import java.util.Set;
public class UnionIntersection{
    public static void main(String[] args){
        Set<Integer> list1=new HashSet<>(Set.of(1,2,3));
        Set<Integer> list2=new HashSet<>(Set.of(3,4,5));
        System.out.println("Set 1: "+list1);
        System.out.println("Set 2: "+list2);
        Set<Integer> union=new HashSet<>(list1);
        union.addAll(list2);
        System.out.println("Union: "+union);
        Set<Integer> intersect=new HashSet<>(list1);
        intersect.retainAll(list2);
        System.out.println("Intersection: "+intersect);
    }
}