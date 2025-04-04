package cordility.assignments;

public class PasswordStrength {
	public static String checkPasswordStrength(String password) {

        if (password.length() < 8) {
            return "Weak: Password must be at least 8 characters long.";
        }
        

        if (!password.matches(".*[A-Z].*")) {
            return "Weak: Password must contain at least one uppercase letter.";
        }


        if (!password.matches(".*[a-z].*")) {
            return "Weak: Password must contain at least one lowercase letter.";
        }

        if (!password.matches(".*[0-9].*")) {
            return "Weak: Password must contain at least one digit.";
        }


        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            return "Weak: Password must contain at least one special character.";
        }


        if (password.matches(".*([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])\\1.*")) {
            return "Weak: Password should not contain repeated characters.";
        }


        String[] commonPasswords = {"password", "123456", "qwerty", "abc123", "letmein"};
        for (String commonPassword : commonPasswords) {
            if (password.toLowerCase().contains(commonPassword)) {
                return "Weak: Password is too common.";
            }
        }


        return "Strong: Your password is strong.";
    }

    public static void main(String[] args) {

        String[] testPasswords = {
            "password123", 
            "StrongPass1@",
            "1234", 
            "abcXYZ!", 
            "qwerty123", 
            "A1b@cdeF", 
            "aaaaaaa", 
            "Hello123!"
        };


        for (String password : testPasswords) {
            System.out.println("Password: \"" + password + "\"");
            System.out.println(checkPasswordStrength(password));
            System.out.println("-----------------------------------------");
        }
    }
}
