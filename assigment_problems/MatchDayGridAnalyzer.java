import java.util.Scanner;
public class MatchDayGridAnalyzer {
    static double rowAverage(int[] row){
        double average, sum = 0;
        for (int i = 0; i < row.length; i++){
            sum += row[i];
        }
        average = sum / row.length;
        return average;
    }
    static String classifyMatches(int[][] runsPerOver, int threshold){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < runsPerOver.length; i++){
            double avg = rowAverage(runsPerOver[i]);
            result.append("Match ").append(i).append(": ");
            if (avg < threshold){
                result.append("Normal");
            } else if (avg >= threshold){
                result.append("Power Surge");
            }
            if (i <= runsPerOver.length){
                result.append(" | ");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of Matches: ");
        int rows = sc.nextInt();
        System.out.print("Enter no.of overs: ");
        int columns = sc.nextInt();
        int[][] matches = new int[rows][columns];
        System.out.print("Enter Runs per Over: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matches[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter Threshold Value: ");
        int threshold = sc.nextInt();
        String result = classifyMatches(matches, threshold);
        System.out.println(result);
        sc.close();
    }
}
