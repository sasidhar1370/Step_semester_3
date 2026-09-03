import java.util.InputMismatchException;
import java.util.Scanner;

public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        try {
            if (seatNumbers == null || seatNumbers.length == 0) {
                throw new IllegalArgumentException("Seat numbers array cannot be null or empty.");
            }

            boolean duplicateFound = false;
            boolean[] reported = new boolean[seatNumbers.length];

            for (int i = 0; i < seatNumbers.length; i++) {
                if (reported[i]) continue;

                for (int j = i + 1; j < seatNumbers.length; j++) {
                    if (seatNumbers[i] == seatNumbers[j]) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        duplicateFound = true;
                        reported[j] = true;
                    }
                }
            }

            if (!duplicateFound) {
                System.out.println("No Duplicate Seats Found");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of seats to process: ");
            int numSeats = scanner.nextInt();

            if (numSeats <= 0) {
                System.out.println("Number of seats must be greater than zero.");
                return;
            }

            int[] seatNumbers = new int[numSeats];
            System.out.println("Enter the seat numbers (separated by space or enter): ");
            for (int i = 0; i < numSeats; i++) {
                seatNumbers[i] = scanner.nextInt();
            }

            System.out.println("\n--- Processing Seats ---");
            checkDuplicateSeats(seatNumbers);

        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integer numbers only.");
        } finally {
            scanner.close();
        }
    }
}