import java.io.*;
import java.util.*;
import java.io.Serializable;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}
public class Serialization {
	private static final String FILE_NAME = "employees.ser";
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Sasanka", "HR", 55000));
        employees.add(new Employee(102, "Bharath", "IT", 70000));
        employees.add(new Employee(103, "Abhinaya", "Finance", 60000));
        serializeEmployees(employees);
        List<Employee> retrievedEmployees = deserializeEmployees();
        if (retrievedEmployees != null) {
            System.out.println("Retrieved Employees:");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
        }
    }
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employee list serialized successfully.");
        } catch (IOException e) {
            System.err.println("IOException during serialization: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.err.println("IOException during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
        }
        return null;
    }
}
