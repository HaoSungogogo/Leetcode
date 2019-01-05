class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int island = 0;
        int neighbor = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        neighbor++;
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        neighbor++;
                    }
                }
            }
        }
        return island * 4 - neighbor * 2;
    }
}
