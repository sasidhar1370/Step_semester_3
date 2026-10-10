import java.util.Scanner;
public class BusiestBusRow {
    public static void busiestRow(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxTotal = -1;
        int busiestRowIndex = 0;
        for (int i = 0; i < r; i++) {
            int currentRowTotal = 0;
            for (int j = 0; j < c; j++) {
                currentRowTotal += grid[i][j];
            }
            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                busiestRowIndex = i;
            }
        }
        System.out.println("Row " + busiestRowIndex + ", Total " + maxTotal);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] grid = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            busiestRow(grid);
        }
        sc.close();
    }
}