import java.util.Scanner;
public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }
        int[] frequency = new int[256]; // ASCII character frequency array
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter string: ");
            String text = scanner.nextLine();
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}