import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Invalid student");
        }
        students.add(student);
    }

    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public int getCount() {
        return students.size();
    }

    public void performAction(int choice) {
        if (choice < 1 || choice > 3) {
            throw new IllegalArgumentException("Invalid action");
        }
    }
}