import java.util.*;

public class Classroom {
    private String name;
    private Set<Student> students;
    private Set<String> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashSet<>();
        this.assignments = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addAssignment(String assignmentDetails) {
        assignments.add(assignmentDetails);
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public boolean hasAssignment(String assignmentDetails) {
        return assignments.contains(assignmentDetails);
    }

    public void submitAssignment(Student student, String assignmentDetails) {
        if (!hasStudent(student)) {
            throw new IllegalArgumentException("Student is not enrolled in this class");
        }
        if (!hasAssignment(assignmentDetails)) {
            throw new IllegalArgumentException("Assignment does not exist for this class");
        }
        System.out.println("Assignment '" + assignmentDetails + "' submitted by student " + student.getId() + " in class " + name);
    }

    public Set<Student> getStudents() {
        return new HashSet<>(students);
    }
}