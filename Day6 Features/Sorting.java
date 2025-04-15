import java.util.*;
class Person{
    String name;
    int age;
    double salary;
    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}
public class Sorting{
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Abhinaya", 30, 50000),
            new Person("Bharath", 25, 60000),
            new Person("Sasanka", 35, 55000)
        );
        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));
        people.forEach(System.out::println);
    }
}
