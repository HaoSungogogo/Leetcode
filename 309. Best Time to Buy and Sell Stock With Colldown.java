Stupid way -> the running time is too slow.

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] minDp = new int[prices.length + 1][prices.length + 1];
        for (int j = 1; j < prices.length + 1; j++) {
            for (int i = j; i >= 1; i--) {
                if (i == j) {
                    minDp[i][j] = prices[i - 1];
                } else {
                    minDp[i][j] = Math.min(prices[i - 1], minDp[i + 1][j]);
                }
            }
        }
        int[] dp = new int[prices.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                if(j == 0 || j == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + prices[i - 1] - minDp[1][i - 1]);
                } else if (j >= i - 2) {
                    dp[i] = Math.max(dp[i], dp[j]);
                } else {
                    dp[i] = Math.max(dp[i], dp[j] + prices[i - 1] - minDp[j + 2][i - 1]);
                }
            }
        }
        return dp[dp.length - 1];
    }
}

This problem is special since two operaion could be down many times, so we need keey two array to record
these two operations.

Induction rule:
buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
buy[i] represents that we will get max profit on the ith day with the sequence operation ending with buy.
sell[i] represents that we will get max profit on the ith day with the sequence operation ending with sell.

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            if (i == 0) {
                buy[i] = - prices[i];
                sell[i] = 0;
            } else if (i == 1) {
                buy[i] = Math.max(buy[i - 1], -prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            } else {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            }
        }
        return sell[prices.length - 1];
    }
}
