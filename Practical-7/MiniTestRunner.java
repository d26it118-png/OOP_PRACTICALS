
import java.lang.annotation.*;
import java.lang.reflect.*;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

// Class containing test methods
class MyTests {

    @Run
    public void testAddition() {
        System.out.println("Addition test passed");
    }

    @Run
    public void testSubtraction() {
        System.out.println("Subtraction test passed");
    }

    public void normalMethod() {
        System.out.println("This method will not run");
    }

    @Run
    public void testMultiplication() {
        System.out.println("Multiplication test passed");
    }
}

// Mini test runner
public class MiniTestRunner {

    public static void main(String[] args)
            throws Exception {

        MyTests obj = new MyTests();

        Class<?> cls = obj.getClass();
        int count = 0;

        for (Method method : cls.getDeclaredMethods()) {

            // Find methods marked with @Run
            if (method.isAnnotationPresent(Run.class)) {

                // Invoke the method
                method.invoke(obj);
                count++;
            }
        }

        System.out.println("Total tests executed: " + count);
    }
}
