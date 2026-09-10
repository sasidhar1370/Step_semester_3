import java.util.Scanner;
public class CustomerNameReverser {
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return "";
        }
        char[] chars = customerName.toCharArray();
        char[] reversedChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversedChars[i] = chars[chars.length - 1 - i];
        }
        return new String(reversedChars);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Customer Name: ");
            String originalName = scanner.nextLine();
            String reversedName = reverseCustomerName(originalName);
            System.out.println("Original Name: " + originalName);
            System.out.println("Reversed Name: " + reversedName);
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}