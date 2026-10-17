import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void testAddingStudentIncreasesCount() {
        StudentService service = new StudentService();

        assertEquals(0, service.getCount());

        service.addStudent(new Student(1, "Jigar"));

        assertEquals(1, service.getCount());
    }

    @Test
    public void testAddingMultipleStudents() {
        StudentService service = new StudentService();

        service.addStudent(new Student(1, "Jigar"));
        service.addStudent(new Student(2, "Rahul"));

        assertEquals(2, service.getCount());
    }

    @Test
    public void testInvalidActionThrowsException() {
        StudentService service = new StudentService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.performAction(5));
    }
}