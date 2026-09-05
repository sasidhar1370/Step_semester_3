import java.util.Scanner;
import java.util.Arrays;
public class PodiumFinder {
    public static int[] findTopThreeScores(int[] scores){
        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 0; i < scores.length; i++){
            int current = scores[i];
            if (current > first){
                third = second;
                second = first;
                first = current;
            } else if (current > second){
                third = second;
                second = current;
            } else if (current > third){
                third = current;
            }
        }
        return new int[] {first, second, third};
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of Scores: ");
        int n = sc.nextInt();
        System.out.print("Enter Scores: ");
        int[] scores = new int[n];
        for (int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(findTopThreeScores(scores)));
        sc.close();
    }
}
