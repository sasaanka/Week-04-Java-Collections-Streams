import java.util.*;
public class RemoveDuplicates{
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(5);
        System.out.println("Original list: "+list);
        System.out.println("After removing duplicates: "+removingdups(list));
    }
    public static List<Integer> removingdups(List<Integer> list){
        Set<Integer> seen=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        for(Integer item:list){
            if(!seen.contains(item)){
                seen.add(item);
                result.add(item);
            }
        }
        return result;
    }
}