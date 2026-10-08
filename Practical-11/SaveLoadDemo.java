import java.io.*;

class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;

    // This field will NOT be saved
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    void display() {
        System.out.println("ID       : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Password : " + password);
        System.out.println();
    }
}

public class SaveLoadDemo {

    public static void main(String[] args) {

        String fileName = "students.dat";

        Student[] students = {
            new Student(101, "Jigar", "abc123"),
            new Student(102, "Rahul", "xyz456"),
            new Student(103, "Amit", "pass789")
        };

        // Save objects
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(students);
            System.out.println("Objects saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load objects
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            Student[] loadedStudents = (Student[]) in.readObject();

            System.out.println("\nObjects loaded from file:");
            for (Student student : loadedStudents) {
                student.display();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}