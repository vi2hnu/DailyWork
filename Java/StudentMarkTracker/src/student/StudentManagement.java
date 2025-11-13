package student;
import java.util.*;

public class StudentManagement {
    private final Map<Integer, Student> students;

    public StudentManagement() {
        this.students = new HashMap<>();
    }

    public void addStudent(String name, int rollNumber, double grade) {
        if (students.containsKey(rollNumber)) {
            System.out.println("Student with this roll number already exists.");
            return;
        }
        students.put(rollNumber, new Student(name, rollNumber, grade));
        System.out.println("Student added successfully.");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students.values()) {
            System.out.println(s);
        }
    }

    public void updateGrade(int rollNumber, double newGrade) {
        Student s = students.get(rollNumber);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        s.setGrade(newGrade);
        System.out.println("Grade updated for " + s.getName());
    }

    public void removeStudent(int rollNumber) {
        if (students.remove(rollNumber) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void viewStudent(int rollNumber) {
        Student s = students.get(rollNumber);
        if (s == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(s);
        }
    }
}
