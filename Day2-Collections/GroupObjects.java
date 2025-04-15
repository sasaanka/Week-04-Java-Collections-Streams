import java.util.*;
class Employee {
    private final String name;
    private final String department;
    public Employee(String name, String dept) {
        this.name = name;
        this.department = dept;
    }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    @Override public String toString() { return name; }
}
public class GroupObjects {
    public static Map<String, List<Employee>> groupof(List<Employee> emps) {
        Map<String, List<Employee>> map = new HashMap<>();
        for (Employee e : emps) {
            map.computeIfAbsent(e.getDepartment(), d -> new ArrayList<>()).add(e);
        }
        return map;
    }
    public static void main(String[] args) {
        List<Employee> emps = List.of(
            new Employee("Alice", "HR"),
            new Employee("Bob",   "IT"),
            new Employee("Carol", "HR")
        );
        Map<String, List<Employee>> grouped = groupof(emps);
        grouped.forEach((dept, list) ->System.out.println(dept + ": " + list));
    }
}
