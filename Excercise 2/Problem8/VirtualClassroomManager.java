import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.*;

public class VirtualClassroomManager {
    private static final Logger logger = Logger.getLogger(VirtualClassroomManager.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("classroom_manager.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);  // This prevents logging to the console
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Classroom> classrooms;
    private Map<String, Student> students;

    public VirtualClassroomManager() {
        this.classrooms = new HashMap<>();
        this.students = new HashMap<>();
    }

    public void addClassroom(String className) {
        try {
            if (classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom already exists");
            }
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
            logger.info("Classroom created: " + className);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            logger.log(Level.WARNING, "Failed to create classroom", e);
        }
    }
    public void removeClassroom(String className) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom does not exist");
            }
            Classroom removedClassroom = classrooms.remove(className);
            // Remove all students from this classroom
            for (Student student : removedClassroom.getStudents()) {
                students.remove(student.getId());
            }
            System.out.println("Classroom " + className + " has been removed.");
            logger.info("Classroom removed: " + className);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            logger.log(Level.WARNING, "Failed to remove classroom", e);
        }
    }

    public void addStudent(String studentId, String className) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom does not exist");
            }
            if (students.containsKey(studentId)) {
                throw new IllegalArgumentException("Student ID already exists");
            }
            Student student = new Student(studentId);
            students.put(studentId, student);
            classrooms.get(className).addStudent(student);
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
            logger.info("Student " + studentId + " enrolled in " + className);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            logger.log(Level.WARNING, "Failed to add student", e);
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom does not exist");
            }
            classrooms.get(className).addAssignment(assignmentDetails);
            System.out.println("Assignment for " + className + " has been scheduled.");
            logger.info("Assignment scheduled for " + className);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            logger.log(Level.WARNING, "Failed to schedule assignment", e);
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom does not exist");
            }
            if (!students.containsKey(studentId)) {
                throw new IllegalArgumentException("Student does not exist");
            }
            Classroom classroom = classrooms.get(className);
            Student student = students.get(studentId);
            if (!classroom.hasStudent(student)) {
                throw new IllegalArgumentException("Student is not enrolled in this class");
            }
            if (!classroom.hasAssignment(assignmentDetails)) {
                throw new IllegalArgumentException("Assignment does not exist for this class");
            }
            classroom.submitAssignment(student, assignmentDetails);
            System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
            logger.info("Assignment submitted by Student " + studentId + " in " + className);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            logger.log(Level.WARNING, "Failed to submit assignment", e);
        }
    }

    public void listClassrooms() {
        System.out.println("Classrooms:");
        for (String className : classrooms.keySet()) {
            System.out.println("- " + className);
        }
    }

    public void listStudentsInClass(String className) {
        try {
            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Classroom does not exist");
            }
            System.out.println("Students in " + className + ":");
            for (Student student : classrooms.get(className).getStudents()) {
                System.out.println("- " + student.getId());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            logger.log(Level.WARNING, "Failed to list students", e);
        }
    }

    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (or 'exit' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                break;
            }

            String[] parts = input.split(" ", 4);
            String command = parts[0];

            try {
                switch (command) {
                    case "add_classroom":
                        if (parts.length < 2) throw new IllegalArgumentException("Missing classroom name");
                        manager.addClassroom(parts[1]);
                        break;
                    case "remove_classroom":
                        if (parts.length < 2) throw new IllegalArgumentException("Missing classroom name");
                        manager.removeClassroom(parts[1]);
                        break;
                    case "add_student":
                        if (parts.length < 3) throw new IllegalArgumentException("Missing student ID or class name");
                        manager.addStudent(parts[1], parts[2]);
                        break;
                    case "schedule_assignment":
                        if (parts.length < 3) throw new IllegalArgumentException("Missing class name or assignment details");
                        manager.scheduleAssignment(parts[1], parts[2]);
                        break;
                    case "submit_assignment":
                        if (parts.length < 4) throw new IllegalArgumentException("Missing student ID, class name, or assignment details");
                        manager.submitAssignment(parts[1], parts[2], parts[3]);
                        break;
                    case "list_classrooms":
                        manager.listClassrooms();
                        break;
                    case "list_students":
                        if (parts.length < 2) throw new IllegalArgumentException("Missing class name");
                        manager.listStudentsInClass(parts[1]);
                        break;
                    default:
                        System.out.println("Unknown command. Available commands: add_classroom, remove_classroom, add_student, schedule_assignment, submit_assignment, list_classrooms, list_students");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                logger.log(Level.WARNING, "Invalid command", e);
            }
        }

        scanner.close();
    }
}