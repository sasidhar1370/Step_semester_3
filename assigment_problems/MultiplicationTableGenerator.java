import java.util.Scanner;

public class MultiplicationTableGenerator {
    public static void generateFirstValidTable(int[] candidates) {
        for (int candidate : candidates) {
            if (candidate < 1) {
                System.out.println("Skipping invalid number: " + candidate);
                continue;
            }

            for (int j = 1; j <= 10; j++) {
                System.out.println(candidate + " x " + j + " = " + (candidate * j));
            }
            break; // Stop after processing the first valid candidate
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of candidate values: ");
        int count = scanner.nextInt();
        int[] candidates = new int[count];

        System.out.println("Enter the candidate numbers:");
        for (int i = 0; i < count; i++) {
            candidates[i] = scanner.nextInt();
        }

        generateFirstValidTable(candidates);
        scanner.close();
    }
}