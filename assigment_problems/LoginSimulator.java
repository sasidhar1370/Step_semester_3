import java.util.Scanner;

public class LoginSimulator {
    public static void simulateLogin(String correctCode, String[] attempts) {
        boolean granted = false;
        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                granted = true;
                break;
            }
        }
        if (!granted) {
            System.out.println("Access denied all attempts used");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter correct access code: ");
        String correctCode = scanner.next();

        System.out.print("Enter number of attempts (max 3): ");
        int count = scanner.nextInt();
        String[] attempts = new String[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = scanner.next();
        }

        simulateLogin(correctCode, attempts);
        scanner.close();
    }
}