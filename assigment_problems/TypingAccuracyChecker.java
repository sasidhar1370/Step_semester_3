import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        try {
            if (original == null || typed == null) {
                throw new IllegalArgumentException("Input strings cannot be null.");
            }
            if (original.length() != typed.length()) {
                throw new IllegalArgumentException("Original and typed strings must be of equal length.");
            }

            int totalChars = original.length();
            if (totalChars == 0) {
                System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
                return;
            }

            int matchedCount = 0;
            int firstMismatchIndex = -1;

            for (int i = 0; i < totalChars; i++) {
                if (original.charAt(i) == typed.charAt(i)) {
                    matchedCount++;
                } else if (firstMismatchIndex == -1) {
                    firstMismatchIndex = i;
                }
            }

            double accuracy = ((double) matchedCount / totalChars) * 100;
            String accuracyFormatted = String.format("%.2f", accuracy);

            if (firstMismatchIndex == -1) {
                System.out.println("Matched: " + matchedCount + "/" + totalChars +
                        " | Accuracy: " + accuracyFormatted + "% | No Mismatches");
            } else {
                int position = firstMismatchIndex + 1;
                char expectedChar = original.charAt(firstMismatchIndex);
                char actualChar = typed.charAt(firstMismatchIndex);

                System.out.println("Matched: " + matchedCount + "/" + totalChars +
                        " | Accuracy: " + accuracyFormatted + "% | First Mismatch at position " +
                        position + " ('" + expectedChar + "' vs '" + actualChar + "')");
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
            System.out.print("Enter the original text: ");
            String original = scanner.nextLine();

            System.out.print("Enter the typed text: ");
            String typed = scanner.nextLine();

            System.out.println("\n--- Checking Accuracy ---");
            checkTypingAccuracy(original, typed);

        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}