import java.util.ArrayList;
import java.util.List;
public class Rotate{
    public static List<Integer> rotatelist(List<Integer> list,int k){
        int n=list.size();
        k=k%n;
        List<Integer> rotatedone=new ArrayList<>();
        for(int i=k;i<n;i++){
            rotatedone.add(list.get(i));
        }
        for(int i=0;i<k;i++){
            rotatedone.add(list.get(i));
        }
        return rotatedone;
    }
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(25);
        list.add(48);
        list.add(91);
        list.add(82);
        list.add(24);
        list.add(6);
        int k=3;
        System.out.println("Original list: "+list);
        rotatelist(list, k);
        List<Integer> rotated = rotatelist(list, k);
        System.out.println("Rotated list: "+rotated);
    }
}