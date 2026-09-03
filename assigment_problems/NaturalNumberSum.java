import java.util.Scanner;

public class NaturalNumberSum {
    public static void sumOfNaturalNumbers(int n) {
        int sum = 0;
        int counter = 1;
        while (counter <= n) {
            sum += counter;
            counter++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        sumOfNaturalNumbers(n);
        scanner.close();
    }
}