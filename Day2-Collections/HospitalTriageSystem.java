import java.util.*;
class Patient{
    String name;
    int severity;
    public Patient(String name,int severity){
        this.name=name;
        this.severity=severity;
    }
    @Override
    public String toString(){
        return name+" ("+severity+" )";
    }
}
public class HospitalTriageSystem{
    public static void main(String[] args) {
        Queue<Patient> q=new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));
        q.add(new Patient("John", 3));
        q.add(new Patient("Alice", 5));
        q.add(new Patient("Bob", 2));
        System.out.print("Order: ");
        while (!q.isEmpty()) {
            System.out.print(q.remove().name+" ");
        }
    }
}