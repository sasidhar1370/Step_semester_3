import java.util.Scanner;

public class PrimeChecker {
    public static void checkPrime(int number) {
        if (number <= 1) {
            System.out.println("Not Prime");
            return;
        }

        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        checkPrime(number);
        scanner.close();
    }
}