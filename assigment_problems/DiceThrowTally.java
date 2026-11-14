import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        // Array of size 7 so index v directly tracks the count of face value v (1 to 6)
        int[] count = new int[7];

        for (int roll : rolls) {
            count[roll]++;
        }

        // Print the frequency counts from 1 to 6
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v < 6 ? " " : ""));
        }
        System.out.println();

        // Reconstruct the sorted array using the counts (no element-to-element comparisons)
        int[] sorted = new int[rolls.length];
        int index = 0;

        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        // Sample Input
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        System.out.println("Sample Input: " + Arrays.toString(rolls1));
        int[] sorted1 = diceSort(rolls1);
        System.out.println("Sorted: " + Arrays.toString(sorted1));

        // Custom Input
        int[] customRolls = {6, 6, 3, 1, 5, 3, 2, 6};
        System.out.println("\nCustom Input: " + Arrays.toString(customRolls));
        int[] sortedCustom = diceSort(customRolls);
        System.out.println("Sorted: " + Arrays.toString(sortedCustom));
    }
}