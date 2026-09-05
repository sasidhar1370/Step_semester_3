import java.util.Scanner;
import java.util.Arrays;
public class ScoreCurveBooster{
    public static void curveScores(int[] scores, int bonus){
        for(int i = 0; i < scores.length; i++){
            scores[i] += bonus;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bonus Score: ");
        int bonus = sc.nextInt();
        System.out.print("Enter no.of Scores: ");
        int n = sc.nextInt();
        System.out.print("Enter Scores: ");
        int[] scores = new int[n];
        for (int i = 0; i < n; i++){
           scores[i] = sc.nextInt();
        }
        curveScores(scores, bonus);
        System.out.println(Arrays.toString(scores));
        sc.close();
    }
}