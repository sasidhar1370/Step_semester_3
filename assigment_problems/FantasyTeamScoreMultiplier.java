import java.util.Scanner;
import java.util.Arrays;
public class FantasyTeamScoreMultiplier {
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex){
        playerScores[captainIndex] = 2.0 * playerScores[captainIndex];
        playerScores[viceCaptainIndex] = 1.5 * playerScores[viceCaptainIndex];
        System.out.println(Arrays.toString(playerScores));
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of Team Members: ");
        int n = sc.nextInt();
        System.out.print("Enter Team Scores: ");
        double[] scores = new double[n];
        for (int i = 0; i < n; i++){
            scores[i] = sc.nextDouble();
        }
        System.out.print("Enter Captain Position: ");
        int captainIndex = sc.nextInt();
        System.out.print("Enter Vice-captain Position: ");
        int viceCaptainIndex = sc.nextInt();
        applyMultipliers(scores, captainIndex, viceCaptainIndex);
        sc.close();
    }
}
