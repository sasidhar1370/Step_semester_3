import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: suffix products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
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

        int[] result = productExceptSelf(nums);
        System.out.println("Output: " + Arrays.toString(result));
        scanner.close();
    }
}