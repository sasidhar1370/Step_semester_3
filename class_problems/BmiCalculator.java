import java.util.Scanner;
public class BmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights arrays must be non-null and equal in length.");
        }
        System.out.println("\n---------------------------------------------------------------");
        System.out.printf("%-8s | %-10s | %-11s | %-7s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] <= 0 || weights[i] <= 0) {
                System.out.printf("%-8s | %-10.2f | %-11.2f | %-7s | %-12s\n",
                        "Person " + (i + 1), heights[i], weights[i], "N/A", "Invalid Input");
                continue;
            }
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-8s | %-10.2f | %-11.2f | %-7.2f | %-12s\n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println("---------------------------------------------------------------");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of team members: ");
            int count = scanner.nextInt();
            if (count <= 0) {
                System.out.println("Team count must be greater than zero.");
                return;
            }
            double[] heights = new double[count];
            double[] weights = new double[count];
            for (int i = 0; i < count; i++) {
                System.out.print("Person " + (i + 1) + " Height (m): ");
                heights[i] = scanner.nextDouble();
                System.out.print("Person " + (i + 1) + " Weight (kg): ");
                weights[i] = scanner.nextDouble();
            }
            printWellnessReport(heights, weights);
        } catch (Exception e) {
            System.err.println("Error: Please enter valid numeric details.");
        } finally {
            scanner.close();
        }
    }
}