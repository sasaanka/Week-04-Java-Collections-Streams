import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
public class StackwithQueue<T> {
    private final Queue<T> q1 = new LinkedList<>();
    private final Queue<T> q2 = new LinkedList<>();
    public void push(T x) {
        q1.add(x);
    }
    public T pop() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        T top = q1.remove();
        swapQueues();
        return top;
    }
    public T top() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        T top = q1.remove();
        q2.add(top);
        swapQueues();
        return top;
    }
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    private void swapQueues() {
        @SuppressWarnings("unused")
        Queue<T> temp = q1;
        q1.clear();
        q1.addAll(q2);
        q2.clear();
    }
    public static void main(String[] args) {
        StackwithQueue<Integer> stack = new StackwithQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());   
        System.out.println("Pop: " + stack.pop());   
        System.out.println("Is empty? " + stack.isEmpty()); 
    }
}
