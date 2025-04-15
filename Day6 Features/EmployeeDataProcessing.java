import java.util.*;
import java.util.stream.Collectors;
class Employee{
    @SuppressWarnings("unused")
    int id;
    String name;
    String department;
    double salary;
    Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString(){
        return name + " (" + department + ", Rs." + salary + " )";
    }
}
public class EmployeeDataProcessing{
    static void processingData(List<Employee> employees){
         List<Employee> employeeSalary = employees.stream().filter(e -> e.department.equals("Engineering") && e.salary > 80000)
        .sorted((e1,e2) -> Double.compare(e1.salary, e2.salary)) 
        .collect(Collectors.toList());

        Map<String, List<Employee>> groupedbyDepart  = employeeSalary.stream()
        .collect(Collectors.groupingBy(e -> e.department));

        Map<String, Double> avgSalary = groupedbyDepart.entrySet().stream()
        .collect(Collectors.toMap(
        Map.Entry::getKey,
        entry -> entry.getValue().stream().mapToDouble(e -> e.salary).average().orElse(0.0)
        ));

        groupedbyDepart.forEach((dept,empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(System.out::println);
            System.out.println("Average Salary: Rs." + avgSalary.get(dept));
            System.out.println();
        });
    }
    public static void main(String[] args){

        List<Employee> employees = Arrays.asList(new Employee(1,"Abhi","CSE",200000),
        new Employee(2,"Sasanka","Engineering",240000),
        new Employee(3,"Shasank","Arts",123000),
        new Employee(4,"HemaTeja","Engineering",230000),
        new Employee(5,"Bharath","Law",123590));    
        processingData(employees);
    }
}