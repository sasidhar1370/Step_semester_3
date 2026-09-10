import java.util.Scanner;
public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Input text cannot be null.");
            return;
        }
        int vowels = 0;
        int consonants = 0;
        String lowerText = text.toLowerCase();
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter text: ");
            String text = scanner.nextLine();
            countVowelsAndConsonants(text);
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}