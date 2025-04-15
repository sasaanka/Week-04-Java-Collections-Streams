import java.util.*;
public class Subsetornot{
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Set.of(15,74,2,3,9,5,1,8));
        Set<Integer> set2=new HashSet<>(Set.of(2,3,74));
        boolean issubset=set1.containsAll(set2);
        System.out.println("Is subset? "+issubset);
    }
}