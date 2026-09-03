import java.util.Scanner;

public class AtmPinRetry {
    public static void atmPinRetry(String correctPin, String[] attempts) {
        int index = 0;
        boolean success = false;

        while (index < attempts.length && index < 3 && !success) {
            if (attempts[index].equals(correctPin)) {
                System.out.println("PIN accepted");
                success = true;
                break;
            }
            index++;
        }

        if (!success) {
            System.out.println("Card blocked too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter correct PIN: ");
        String correctPin = scanner.next();

        System.out.print("Enter number of attempts made (up to 3): ");
        int count = scanner.nextInt();
        String[] attempts = new String[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = scanner.next();
        }

        atmPinRetry(correctPin, attempts);
        scanner.close();
    }
}