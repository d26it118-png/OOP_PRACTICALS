
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// Annotation to check empty fields
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

// Annotation to check maximum length
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Signup form
class SignupForm {
    @NotBlank
    @MaxLength(20)
    String username;

    @NotBlank
    @MaxLength(30)
    String email;

    SignupForm(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

// Validator class
public class FormValidator {

    static List<String> validate(Object obj)
            throws IllegalAccessException {

        List<String> errors = new ArrayList<>();

        Class<?> cls = obj.getClass();

        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);

            Object value = field.get(obj);
            String name = field.getName();

            // Check @NotBlank
            if (field.isAnnotationPresent(NotBlank.class)) {
                if (value == null ||
                        value.toString().trim().isEmpty()) {
                    errors.add(name + " must not be blank");
                }
            }

            // Check @MaxLength
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);

                if (value != null &&
                        value.toString().length() > annotation.value()) {
                    errors.add(name + " exceeds maximum length "
                            + annotation.value());
                }
            }
        }

        return errors;
    }

    public static void main(String[] args)
            throws IllegalAccessException {

        SignupForm form = new SignupForm("",
                "thisisaverylongemailaddress@example.com");

        List<String> errors = validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
