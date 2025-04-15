import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ReverseaList{
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(15);
        list.add(25);
        System.out.println("Actual list: "+list);
        reversearrayList(list);
        System.out.println("Reversed list: "+list);

        List<String> ll=new LinkedList<>();
        ll.add("Sasanka");
        ll.add("Poturi");
        ll.add("Bharath");
        ll.add("Chintham");
        System.out.println("Actual Linkedlist: "+ll);
        reverseLinkedlist(ll);
        System.out.println("Reversed Linked list: "+ll);
    }
    public static void reversearrayList(List<Integer> list){
        int n=list.size();
        List<Integer> reverseList=new ArrayList<>();
        for (int i=n-1;i>=0;i--){
            reverseList.add(list.get(i));
        }
        list.clear();
        for(Integer item:reverseList){
            list.add(item);
        }
    }
    public static void reverseLinkedlist(List<String> ll){
        int n=ll.size();
        List<String> reversell=new LinkedList<>();
        for(int i=n-1;i>=0;i--){
            reversell.add(ll.get(i));
        }
        ll.clear();
        for(String text:reversell){
            ll.add(text);
        }
    }

}