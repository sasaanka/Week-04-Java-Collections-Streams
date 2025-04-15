import java.util.*;
public class NthFromEnd{
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(47);
        list.add(78);
        list.add(56);
        list.add(58);
        list.add(94);
        System.out.println("List is: "+list);
        int result=nthone(list, 2);
        System.out.println("Nth number is: "+result);
    }
    public static Integer nthone(List<Integer> list,int n){
        if(n<=0){
            System.err.println("List is not present");
        }
        int fast=n;
        if(fast>list.size()){
            System.err.println("List is shorter than N");
        }
        int slow=0;
        while(fast<list.size()){
            slow++;
            fast++;
        }
        return list.get(slow);
    }
}