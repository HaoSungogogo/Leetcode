Minmax

class Solution {
    public int getMoneyAmount(int n) {
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                if (j - i == 1) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        int local = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                        dp[i][j] = Math.min(dp[i][j], local);
                    }
                }
            }
        }
        return dp[1][n];
    }
}
