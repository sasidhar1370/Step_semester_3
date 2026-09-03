import java.util.Scanner;
public class GuessNumberGame {
    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tryCount = 0;
        boolean guessed = false;
        while (tryCount < maxTries && tryCount < guesses.length && !guessed) {
            int currentGuess = guesses[tryCount];
            if (currentGuess > secretNumber) {
                System.out.println("Too high");
            } else if (currentGuess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }
            tryCount++;
        }
        if (!guessed) {
            System.out.println("Out of tries the number was " + secretNumber);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter secret number: ");
        int secretNumber = scanner.nextInt();
        System.out.print("Enter maximum tries allowed: ");
        int maxTries = scanner.nextInt();
        System.out.print("Enter number of player guesses: ");
        int numGuesses = scanner.nextInt();
        int[] guesses = new int[numGuesses];
        for (int i = 0; i < numGuesses; i++) {
            System.out.print("Enter guess " + (i + 1) + ": ");
            guesses[i] = scanner.nextInt();
        }
        guessTheNumber(secretNumber, maxTries, guesses);
        scanner.close();
    }
}