public class CiruclarBuffer<T> {
    private final T[] buffer;
    private int head = 0;   
    private int tail = 0;   
    private int count = 0; 

    @SuppressWarnings("unchecked")
    public CiruclarBuffer(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        buffer = (T[]) new Object[capacity];
    }
    public void insert(T item) {
        buffer[tail] = item;
        tail = (tail + 1) % buffer.length;
        if (count == buffer.length) {
            head = (head + 1) % buffer.length;
        } else {
            count++;
        }
    }
    public T remove() {
        if (count == 0) return null;
        T item = buffer[head];
        buffer[head] = null; 
        head = (head + 1) % buffer.length;
        count--;
        return item;
    }
    public T peek() {
        return (count == 0) ? null : buffer[head];
    }
    public int size() {
        return count;
    }
    public java.util.List<T> toList() {
        java.util.List<T> list = new java.util.ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(buffer[(head + i) % buffer.length]);
        }
        return list;
    }
        public static void main(String[] args) {
        CiruclarBuffer<Integer> cb = new CiruclarBuffer<>(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println(cb.toList());
        cb.insert(4);                     
        System.out.println(cb.toList()); 
        System.out.println("Removed: " + cb.remove()); 
        System.out.println(cb.toList()); 
    }
}
