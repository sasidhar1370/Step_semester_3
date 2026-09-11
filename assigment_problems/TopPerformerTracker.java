import java.util.Scanner;
public class TopPerformerTracker {
    static String findMinMaxSpread(int[] scores){
        if (scores == null || scores.length < 0){
            return "Invalid";
        }
        int min = scores[0];
        int max = scores[0];
        for (int i = 0; i < scores.length; i++){
            if(scores[i] > max){
                max = scores[i];
            }
            if(scores[i] < min){
                min = scores[i];
            }
        }
        int difference = max- min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + difference;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of Elements: ");
        int n = sc.nextInt();
        System.out.print("Enter Elements: ");
        int[] scores = new int[n];
        for(int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
        }
        String result = findMinMaxSpread(scores);
        System.out.println(result);
        sc.close();
    }
}
