import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Base case for subarrays starting at index 0
        int currentSum = 0;
        int count = 0;
        for (int num : nums) {
            currentSum += num;
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter target sum k: ");
        int k = scanner.nextInt();
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = subarraySum(nums, k);
        System.out.println("Total subarrays with sum " + k + ": " + result);
        scanner.close();
    }
}