import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Count Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("Exiting program...");
                break;
            }

            try {
                service.performAction(choice);

                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();

                        service.addStudent(new Student(id, name));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        ArrayList<Student> students = service.getAllStudents();

                        if (students.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            for (Student s : students) {
                                System.out.println(s);
                            }
                        }
                        break;

                    case 3:
                        System.out.println(
                                "Total Students: " + service.getCount());
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}