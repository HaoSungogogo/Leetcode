Similar to Array Hopper, traverse from end to start, since if we traverse from start to end, we could not
make sure this path we decide could get to the end finally and don't have enough info to decide

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 1;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1 - dungeon[i][j],  1);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                } else {
                    int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                    int down =  Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                    dp[i][j] = Math.min(right, down);
                }
            }
        }
        return dp[0][0];
    }
}
