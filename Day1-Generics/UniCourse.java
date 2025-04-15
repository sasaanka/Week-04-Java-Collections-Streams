import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    final private String course;

    public CourseType(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public abstract String getcoursetype();
    @Override
    public String toString() {
        return getcoursetype();
    }
}

class Exambased extends CourseType {
    public Exambased() {
        super("Exam-Based");
    }

    @Override
    public String getcoursetype() {
        return "Exam course";
    }
}

class AssignmentBased extends CourseType {
    public AssignmentBased() {
        super("Assignment-Based");
    }

    @Override
    public String getcoursetype() {
        return "Assignment-Course";
    }
}

class ResearchBased extends CourseType {
    public ResearchBased() {
        super("Research-Based");
    }

    @Override
    public String getcoursetype() {
        return "Research-course";
    }
}

class Course<T extends CourseType> {
    final private String coursename;
    final private T type;

    public Course(String coursename, T type) {
        this.coursename = coursename;
        this.type = type;
    }

    public String getcoursename() {
        return coursename;
    }

    public T gettype() {
        return type;
    }

    public void display() {
        System.out.println(coursename + " , " + type.getcoursetype());
    }

    public static void displayall(List<? extends CourseType> types) {
        for (CourseType cs : types) {
            System.out.println(cs);
        }
    }
}

public class UniCourse {
    public static void main(String[] args) {
        Course<Exambased> math = new Course<>("Math 101", new Exambased());
        Course<AssignmentBased> english = new Course<>("English Literature", new AssignmentBased());
        Course<ResearchBased> ai = new Course<>("AI Research", new ResearchBased());

        math.display();
        english.display();
        ai.display();

        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new Exambased());
        allCourses.add(new AssignmentBased());
        allCourses.add(new ResearchBased());

        System.out.println("\nDisplaying all course types:");
        Course.displayall(allCourses); 
    }
}
