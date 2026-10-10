import java.util.Scanner;
public class VowelandConsonantCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String word = scanner.next();
            int vowels = 0;
            int consonants = 0;
            String lowerWord = word.toLowerCase();
            for (int i = 0; i < lowerWord.length(); i++) {
                char ch = lowerWord.charAt(i);
                if (Character.isLetter(ch)) {
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }
            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
        }
        scanner.close();
    }
}