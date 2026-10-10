import java.util.Scanner;
public class ClassAttendanceTracker {
    public static void attendanceSummary(int[] days) {
        int totalPresent = 0;
        int currentStreak = 0;
        int longestStreak = 0;
        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        System.out.println("Present: " + totalPresent + ", Longest streak: " + longestStreak);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] days = new int[n];
            for (int i = 0; i < n; i++) {
                days[i] = scanner.nextInt();
            }
            attendanceSummary(days);
        }
        scanner.close();
    }
}