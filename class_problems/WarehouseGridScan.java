public class WarehouseGridScan {

    // Helper class to store both the total item count and the max bin coordinates
    public static class SummaryResult {
        int total;
        int maxRow;
        int maxCol;

        public SummaryResult(int total, int maxRow, int maxCol) {
            this.total = total;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        @Override
        public String toString() {
            return "total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
        }
    }

    public static SummaryResult warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1; // Since item counts are non-negative, -1 ensures the first cell updates maxVal
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int currentItems = grid[row][col];
                total += currentItems;

                // Strictly greater (>) ensures ties keep the first encountered coordinate
                if (currentItems > maxVal) {
                    maxVal = currentItems;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        return new SummaryResult(total, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 9, 2},
                {7, 1, 6},
                {3, 12, 5}
        };

        System.out.println(warehouseSummary(grid)); // total = 49, maxCoordinate = (2, 1)
    }
}