import java.util.Scanner;
public class FindMinRotatedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // Minimum lies in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum lies in the left half including mid
                right = mid;
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements of rotated sorted array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int minElement = findMin(nums);
        System.out.println("Minimum element: " + minElement);
        scanner.close();
    }
}