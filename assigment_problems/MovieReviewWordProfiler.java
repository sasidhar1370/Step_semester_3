import java.util.Scanner;

public class MovieReviewWordProfiler {

    public static void classifyWordLengths(String review) {
        try {
            if (review == null || review.trim().isEmpty()) {
                throw new IllegalArgumentException("Review string cannot be null or empty.");
            }

            String[] words = review.trim().split("\\s+");

            int shortCount = 0;  // 1-4 letters
            int mediumCount = 0; // 5-8 letters
            int longCount = 0;   // 9+ letters

            for (String word : words) {
                String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "");
                int length = cleanedWord.length();

                if (length >= 1 && length <= 4) {
                    shortCount++;
                } else if (length >= 5 && length <= 8) {
                    mediumCount++;
                } else if (length >= 9) {
                    longCount++;
                }
            }

            System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);

        } catch (IllegalArgumentException e) {
            System.err.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the movie review: ");
            String review = scanner.nextLine();

            System.out.println("\n--- Profiling Word Lengths ---");
            classifyWordLengths(review);

        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}