import java.util.Scanner;

public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        try {
            if (signalLog == null || signalLog.trim().isEmpty()) {
                throw new IllegalArgumentException("Signal log cannot be empty.");
            }

            // Remove any potential whitespace from user input
            signalLog = signalLog.trim().toUpperCase();

            char longestStreakColor = signalLog.charAt(0);
            int maxStreakLength = 1;

            char currentStreakColor = signalLog.charAt(0);
            int currentStreakLength = 1;

            for (int i = 1; i < signalLog.length(); i++) {
                char currentChar = signalLog.charAt(i);

                if (currentChar == currentStreakColor) {
                    currentStreakLength++;
                } else {
                    currentStreakColor = currentChar;
                    currentStreakLength = 1;
                }

                if (currentStreakLength > maxStreakLength) {
                    maxStreakLength = currentStreakLength;
                    longestStreakColor = currentStreakColor;
                }
            }

            System.out.println("Longest Streak: '" + longestStreakColor + "' repeated " + maxStreakLength + " times");

        } catch (IllegalArgumentException e) {
            System.err.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the traffic signal log sequence (e.g., RRGGGYRR): ");
            String signalLog = scanner.nextLine();

            System.out.println("\n--- Analyzing Log ---");
            findLongestStreak(signalLog);

        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}