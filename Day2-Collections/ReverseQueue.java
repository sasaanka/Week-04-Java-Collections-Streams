import java.util.LinkedList;
import java.util.Queue;
public class ReverseQueue{
    public static <T> void reverse(Queue<T> q){
        if(q.isEmpty()){
            return;
        }
        T front=q.remove();
        reverse(q);
        q.add(front);
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println("Queue: "+q);
        reverse(q);
        System.out.println("Reversed Queue: "+q);
    }
}