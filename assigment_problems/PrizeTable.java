import java.util.Arrays;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            // Scan from i + 1 to the end to find the index of the largest mark
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap only if the largest mark is not already at index i
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] marks1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(marks1);
        System.out.println(Arrays.toString(marks1) + " swaps = " + swaps1);

        // Sample Input 2
        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);
        System.out.println(Arrays.toString(marks2) + " swaps = " + swaps2);

        // Custom Input
        int[] customMarks = {55, 85, 95, 70, 65};
        int customSwaps = prizeTable(customMarks);
        System.out.println(Arrays.toString(customMarks) + " swaps = " + customSwaps);
    }
}