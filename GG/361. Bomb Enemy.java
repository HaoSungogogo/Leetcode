NiuBi way: only store the num of enemies that were killed on each row and every col;

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = 0;
        int[] col = new int[grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (j == 0 || grid[i][j - 1] == 'W') {
                    row = getKillRow(grid, i, j);
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = getKillCol(grid, i, j);
                }
                if (grid[i][j] == '0') {
                    max = Math.max(max, row + col[j]);
                }
            }
        }
        return max;
    }
    private int getKillRow(char[][] grid, int i, int j) {
        int count = 0;
        while (j < grid[0].length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') {
                count++;
            }
            j++;
        }
        return count;
    }
    private int getKillCol(char[][] grid, int i, int j) {
        int count = 0;
        while (i < grid.length && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') {
                count++;
            }
            i++;
        }
        return count;
    }
}
