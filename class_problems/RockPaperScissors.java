import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            throw new IllegalArgumentException("Moves cannot be null.");
        }
        playerMove = playerMove.trim().toLowerCase();
        computerMove = computerMove.trim().toLowerCase();
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        switch (playerMove) {
            case "rock":
                return computerMove.equals("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equals("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equals("paper") ? "Player Wins" : "Computer Wins";
            default:
                throw new IllegalArgumentException("Invalid move: " + playerMove);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"rock", "paper", "scissors"};
        int rounds = 5;
        int wins = 0, losses = 0, draws = 0;
        String[][] table = new String[rounds][4];
        try {
            System.out.println("Enter your moves for 5 rounds (rock, paper, or scissors):");
            for (int i = 0; i < rounds; i++) {
                System.out.print("Round " + (i + 1) + " move: ");
                String playerMove = scanner.next();
                String computerMove = moves[random.nextInt(3)];
                String result = playRound(playerMove, computerMove);
                if (result.equals("Player Wins")) wins++;
                else if (result.equals("Computer Wins")) losses++;
                else draws++;
                table[i][0] = String.valueOf(i + 1);
                table[i][1] = playerMove;
                table[i][2] = computerMove;
                table[i][3] = result;
            }
            System.out.println("\n-----------------------------------------------------");
            System.out.printf("%-7s | %-12s | %-13s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
            System.out.println("-----------------------------------------------------");
            for (String[] row : table) {
                System.out.printf("%-7s | %-12s | %-13s | %-12s\n", row[0], row[1], row[2], row[3]);
            }
            System.out.println("-----------------------------------------------------");
            double winPercentage = ((double) wins / rounds) * 100;
            System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}