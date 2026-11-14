import java.util.Arrays;

public class QueueOrderCheck {

    public static int firstBreak(int[] tokens) {
        // An empty queue or a queue of one student is always in order
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        // Start at index 1 and compare each token with the one just before it
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i; // Found the first student out of order
            }
        }

        return -1; // The entire queue is in non-decreasing order
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println("Input: " + Arrays.toString(tokens1) + " -> Output: " + firstBreak(tokens1));

        // Sample Input 2
        int[] tokens2 = {1, 2, 2, 7};
        System.out.println("Input: " + Arrays.toString(tokens2) + " -> Output: " + firstBreak(tokens2));

        // Custom Input 1 (Out of order at index 2)
        int[] customTokens1 = {10, 15, 12, 20};
        System.out.println("Input: " + Arrays.toString(customTokens1) + " -> Output: " + firstBreak(customTokens1));

        // Custom Input 2 (Edge case: single element)
        int[] customTokens2 = {42};
        System.out.println("Input: " + Arrays.toString(customTokens2) + " -> Output: " + firstBreak(customTokens2));
    }
}