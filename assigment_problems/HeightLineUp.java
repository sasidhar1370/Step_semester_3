import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 1;

        while (true) {
            boolean swapped = false;

            for (int j = 0; j < n - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    // Swap adjacent students if the left one is taller
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

            // Stop if no swaps occurred during this sweep
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] heights1 = {4, 2, 5, 1};
        System.out.println("Sample Input 1: " + Arrays.toString(heights1));
        lineUp(heights1);

        // Sample Input 2
        int[] heights2 = {1, 3, 2, 4};
        System.out.println("\nSample Input 2: " + Arrays.toString(heights2));
        lineUp(heights2);

        // Custom Input
        int[] customHeights = {10, 8, 9, 7};
        System.out.println("\nCustom Input: " + Arrays.toString(customHeights));
        lineUp(customHeights);
    }
}