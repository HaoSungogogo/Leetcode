class Solution {
    public int minSteps(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * 2 <= i; j++) {
                if (i % j != 0) {
                    continue;
                }
                int val = i / j - 1;
                dp[i] = Math.min(dp[i], dp[j] + 1 + val);
            }
        }
        return dp[n];
    }
}
