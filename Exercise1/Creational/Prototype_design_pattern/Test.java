import java.util.*;
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
            StudentDAO studentDAO = new StudentDAO();

            List<Student> allStudents = studentDAO.getAllStudents();

            List<Student> updatedStudentList = studentDAO.clone();
            Student student = new Student();
            student.setId(30);
            student.setName("Paul");

            updatedStudentList.add(student);
        System.out.println("All students: ");
        allStudents.forEach(System.out::println);

        System.out.println("All students: ");
        updatedStudentList.forEach(System.out::println);
    }
}
