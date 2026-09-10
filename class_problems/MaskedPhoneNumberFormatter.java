import java.util.Scanner;
public class MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return "Error: Phone number cannot be null.";
        }
        String trimmed = phoneNumber.trim();
        if (trimmed.length() != 10) {
            return "Error: Phone number must be exactly 10 digits.";
        }
        for (int i = 0; i < trimmed.length(); i++) {
            if (!Character.isDigit(trimmed.charAt(i))) {
                return "Error: Phone number must contain only numeric digits.";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(trimmed.substring(6));
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10-digit phone number: ");
        String input = scanner.nextLine();
        String result = maskPhoneNumber(input);
        System.out.println(result);
        scanner.close();
    }
}