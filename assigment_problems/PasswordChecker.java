public class PasswordChecker {
    // Private and final field ensures the password cannot be read or modified after creation
    private final String password;

    // Constructor accepts the password once and stores it privately
    public PasswordChecker(String password) {
        this.password = password;
    }

    // Evaluates and returns the strength rating based on password length
    public String getStrength() {
        if (password == null) {
            return "Invalid";
        }

        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    // Main method demonstrating sample usage
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("4 chars strength: " + pc1.getStrength()); // Output: Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("8 chars strength: " + pc2.getStrength()); // Output: Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("10 chars strength: " + pc3.getStrength()); // Output: Strong
    }
}