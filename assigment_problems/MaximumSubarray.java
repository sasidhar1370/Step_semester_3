import java.util.Scanner;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
        scanner.close();
    }
}