public class PasswordChecker {

    // Check password strength
    static String strength(String pw) {

        int count = 0;

        boolean length = pw.length() >= 8;
        boolean upper = pw.matches(".*[A-Z].*");
        boolean digit = pw.matches(".*[0-9].*");
        boolean special = pw.matches(".*[^a-zA-Z0-9].*");

        if (length) count++;
        if (upper) count++;
        if (digit) count++;
        if (special) count++;

        System.out.println("Password: " + pw);
        System.out.println("Length >= 8 : " + length);
        System.out.println("Uppercase   : " + upper);
        System.out.println("Digit       : " + digit);
        System.out.println("Special     : " + special);

        if (count <= 1)
            return "Weak";
        else if (count <= 3)
            return "Medium";
        else
            return "Strong";
    }

    public static void main(String[] args) {

        String[] passwords = {
                "abc",
                "Abcd1234!",
                "Hello12",
                "Java@123"
        };

        for (String pw : passwords) {
            System.out.println("------------------------");
            System.out.println("Strength : " + strength(pw));
            System.out.println();
        }
    }
}