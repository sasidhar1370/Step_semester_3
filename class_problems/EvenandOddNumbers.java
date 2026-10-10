import java.util.Scanner;
public class EvenandOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            input = input.replace("[", "").replace("]", "");
            int evenCount = 0;
            int oddCount = 0;
            if (!input.isEmpty()) {
                String[] parts = input.split(",\\s*");
                for (String part : parts) {
                    int num = Integer.parseInt(part.trim());
                    if (num % 2 == 0) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                }
            }
            System.out.println("Even: " + evenCount);
            System.out.println("Odd: " + oddCount);
        }
        scanner.close();
    }
}