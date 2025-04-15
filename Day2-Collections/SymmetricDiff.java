import java.util.HashSet;
import java.util.Set;
public class SymmetricDiff {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        result.removeAll(intersection);
       return result;
    }
    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1,6,2,3,4);
        Set<Integer> set2 = Set.of(5,6,2,3,8);
        
        Set<Integer> symDiff = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symDiff);
    }
}
