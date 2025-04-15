import java.util.HashSet;
import java.util.Set;
public class SetsareEqual{
    public static void main(String[] args){
        Set<Integer> list1=new HashSet<>();
        list1.add(15);
        list1.add(26);
        list1.add(84);
        list1.add(10);
        Set<Integer> list2=new HashSet<>();
        list2.add(84);
        list2.add(15);
        list2.add(20);
        list2.add(26);
        System.out.println("List 1: "+list1);
        System.out.println("List 2: "+list2);
        boolean areequal=list1.equals(list2);
        System.out.println("Both are equal? "+areequal);
    }
}