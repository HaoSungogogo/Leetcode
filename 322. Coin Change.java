class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (c <= i && dp[i - c] != -1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
            dp[i] = dp[i] == Integer.MAX_VALUE ? -1 : dp[i];
        }
        return dp[amount];
    }
}
