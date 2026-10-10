import java.util.Scanner;

public class DigitSumNumberReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int temp = num;
            int sum = 0;
            int reverse = 0;

            while (temp > 0) {
                int digit = temp % 10;
                sum += digit;
                reverse = (reverse * 10) + digit;
                temp /= 10;
            }

            System.out.println("Sum of digits: " + sum);
            System.out.println("Reverse: " + reverse);
        }

        scanner.close();
    }
}