import java.util.Scanner;
public class ExamScoreBandCounter {
    private static int findLowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private static int findUpperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static int countInBand(int[] scores, int low, int high) {
        int startIndex = findLowerBound(scores, low);
        int endIndex = findUpperBound(scores, high);
        return endIndex - startIndex;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextInt();
            }
            int low = scanner.nextInt();
            int high = scanner.nextInt();
            System.out.println(countInBand(scores, low, high));
        }
        scanner.close();
    }
}