package main;

import java.util.*;
import student.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement manager = new StudentManagement();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. List All Students");
            System.out.println("3. View Student Details");
            System.out.println("4. Update Student Grade");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter grade: ");
                    double grade = sc.nextDouble();
                    manager.addStudent(name, roll, grade);
                    break;

                case 2:
                    manager.listStudents();
                    break;

                case 3:
                    System.out.print("Enter roll number to view: ");
                    int viewRoll = sc.nextInt();
                    manager.viewStudent(viewRoll);
                    break;

                case 4:
                    System.out.print("Enter roll number to update: ");
                    int updateRoll = sc.nextInt();
                    System.out.print("Enter new grade: ");
                    double newGrade = sc.nextDouble();
                    manager.updateGrade(updateRoll, newGrade);
                    break;

                case 5:
                    System.out.print("Enter roll number to remove: ");
                    int removeRoll = sc.nextInt();
                    manager.removeStudent(removeRoll);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
