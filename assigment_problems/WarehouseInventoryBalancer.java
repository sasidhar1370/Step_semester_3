import java.util.InputMismatchException;
import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        try {
            if (sectionA == null || sectionB == null) {
                throw new IllegalArgumentException("Section arrays cannot be null.");
            }
            if (sectionA.length != sectionB.length) {
                throw new IllegalArgumentException("Section A and Section B must have equal lengths.");
            }
            if (sectionA.length == 0) {
                throw new IllegalArgumentException("Section arrays cannot be empty.");
            }

            int totalA = 0;
            int totalB = 0;

            int highestQuantity = Integer.MIN_VALUE;
            String highestSection = "";
            int highestItemIndex = -1;

            for (int i = 0; i < sectionA.length; i++) {
                totalA += sectionA[i];
                if (sectionA[i] > highestQuantity) {
                    highestQuantity = sectionA[i];
                    highestSection = "Section A";
                    highestItemIndex = i + 1;
                }
            }

            for (int i = 0; i < sectionB.length; i++) {
                totalB += sectionB[i];
                if (sectionB[i] > highestQuantity) {
                    highestQuantity = sectionB[i];
                    highestSection = "Section B";
                    highestItemIndex = i + 1;
                }
            }

            String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

            System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
                    " | Status: " + status + " | Highest Quantity: " + highestQuantity +
                    " (" + highestSection + ", Item " + highestItemIndex + ")");

        } catch (IllegalArgumentException e) {
            System.err.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of item categories to process: ");
            int numItems = scanner.nextInt();

            if (numItems <= 0) {
                System.out.println("Number of items must be greater than zero.");
                return;
            }

            int[] sectionA = new int[numItems];
            int[] sectionB = new int[numItems];

            System.out.println("Enter quantities for Section A (separated by space or enter):");
            for (int i = 0; i < numItems; i++) {
                sectionA[i] = scanner.nextInt();
            }

            System.out.println("Enter quantities for Section B (separated by space or enter):");
            for (int i = 0; i < numItems; i++) {
                sectionB[i] = scanner.nextInt();
            }

            System.out.println("\n--- Analyzing Inventory ---");
            analyzeInventory(sectionA, sectionB);

        } catch (InputMismatchException e) {
            System.err.println("Error: Please enter valid integer numbers only.");
        } finally {
            scanner.close();
        }
    }
}