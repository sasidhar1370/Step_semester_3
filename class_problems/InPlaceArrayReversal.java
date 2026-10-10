import java.util.Arrays;
import java.util.Scanner;
public class InPlaceArrayReversal {
    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            input = input.replace("[", "").replace("]", "");
            if (!input.isEmpty()) {
                String[] parts = input.split(",\\s*");
                int[] arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Integer.parseInt(parts[i].trim());
                }
                reverseInPlace(arr);
                System.out.println(Arrays.toString(arr));
            }
        }
        scanner.close();
    }
}