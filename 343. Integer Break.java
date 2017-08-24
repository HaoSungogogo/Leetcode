class Solution {
    public int integerBreak(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }
        return dp[n];
    }
}