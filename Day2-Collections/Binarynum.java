import java.util.*;
public class Binarynum {
    public static List<String> generateBinary(int N) {
        List<String> result = new ArrayList<>();
        if (N <= 0) return result;
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for (int i = 0; i < N; i++) {
            String s = q.remove();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return result;
    }
    public static void main(String[] args) {
        int N = 5;
        List<String> binaries = generateBinary(N);
        System.out.println("First " + N + " binary numbers: " + binaries);
    }
}
