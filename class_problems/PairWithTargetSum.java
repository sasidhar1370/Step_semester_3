import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairWithTargetSum {

    // Approach 1: HashSet (Optimal Time Complexity)
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            // Check if the required complement has already been visited
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    // Approach 2: Sorting + Two Pointers (Optimal Auxiliary Space)
    public static boolean hasPairWithSumTwoPointers(int[] nums, int target) {
        // Clone the array if mutating the original input is undesirable
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int left = 0;
        int right = sortedNums.length - 1;

        while (left < right) {
            int currentSum = sortedNums[left] + sortedNums[right];

            if (currentSum == target) {
                return true;
            } else if (currentSum < target) {
                left++; // Need a larger sum
            } else {
                right--; // Need a smaller sum
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        System.out.println("Result (HashSet): " + hasPairWithSum(nums, target));
        System.out.println("Result (Two Pointers): " + hasPairWithSumTwoPointers(nums, target));

        scanner.close();
    }
}