package main;

import dao.StudentDAO;
import model.Student;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=============================");
            System.out.println("  Student Management System  ");
            System.out.println("=============================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Total Students");
            System.out.println("8. Average Marks");
            System.out.println("9. Exit");
            System.out.print("\nChoose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAll();
                case 3 -> searchById();
                case 4 -> searchByName();
                case 5 -> updateStudent();
                case 6 -> deleteStudent();
                case 7 -> System.out.println("Total Students: " + dao.getTotalStudents());
                case 8 -> System.out.printf("Average Marks: %.2f%n", dao.getAverageMarks());
                case 9 -> { System.out.println("Goodbye! 👋"); System.exit(0); }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Name   : "); String name = sc.nextLine();
        System.out.print("Age    : "); int age = sc.nextInt(); sc.nextLine();
        System.out.print("Email  : "); String email = sc.nextLine();
        System.out.print("Course : "); String course = sc.nextLine();
        System.out.print("Marks  : "); double marks = sc.nextDouble(); sc.nextLine();
        dao.addStudent(new Student(0, name, age, email, course, marks));
    }

    static void viewAll() {
        List<Student> list = dao.getAllStudents();
        if (list.isEmpty()) System.out.println("No students found!");
        else list.forEach(System.out::println);
    }

    static void searchById() {
        System.out.print("Enter ID: ");
        Student s = dao.getStudentById(sc.nextInt()); sc.nextLine();
        System.out.println(s != null ? s : "Student not found!");
    }

    static void searchByName() {
        System.out.print("Enter Name: ");
        List<Student> list = dao.getStudentByName(sc.nextLine());
        if (list.isEmpty()) System.out.println("No students found!");
        else list.forEach(System.out::println);
    }

    static void updateStudent() {
        System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
        System.out.print("New Name   : "); String name = sc.nextLine();
        System.out.print("New Age    : "); int age = sc.nextInt(); sc.nextLine();
        System.out.print("New Email  : "); String email = sc.nextLine();
        System.out.print("New Course : "); String course = sc.nextLine();
        System.out.print("New Marks  : "); double marks = sc.nextDouble(); sc.nextLine();
        dao.updateStudent(id, name, age, email, course, marks);
    }

    static void deleteStudent() {
        System.out.print("Enter ID: ");
        dao.deleteStudent(sc.nextInt()); sc.nextLine();
    }
}
