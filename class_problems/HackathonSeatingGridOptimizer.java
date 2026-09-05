import java.util.Scanner;
public class HackathonSeatingGridOptimizer {
    public static double rowAverage(int[] row){
        double sum = 0;
        for (int i = 0; i < row.length; i++){
            sum += row[i];
        }
        return sum / row.length;
    }
    public static String classifyRows(int[][] seatingScores, int threshold){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++){
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";
            sb.append("Row ").append(i + 1).append(": ").append(zone);
            if (i < seatingScores.length - 1){
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of Rows: ");
        int rows = sc.nextInt();
        int [][] seating = new int[rows][];
        System.out.print("Enter no.of Columns: ");
        int columns = sc.nextInt();
        for(int i = 0; i < rows; i++){
            seating[i] = new int[columns];
            System.out.print("Enter " + columns + " scores for Row " + (i + 1) + ": ");
            for (int j = 0; j < columns; j++){
                seating[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter Threshold Value: ");
        int threshold = sc.nextInt();
        System.out.println(classifyRows(seating, threshold));
        sc.close();
    }
}