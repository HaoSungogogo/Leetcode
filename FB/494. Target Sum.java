Using Dp time: O(n^2)

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (S > sum || S < -sum) {
            return 0;
        }
        int[] dp = new int[sum * 2 + 1];
        dp[0 + sum] = 1;
        for (int n : nums) {
            int[] temp = new int[sum * 2 + 1];
            for (int i = 0; i < temp.length; i++) {
                if (i - n >= 0 && dp[i - n] != 0) {
                    temp[i] += dp[i - n];
                }
                if (i + n < dp.length && dp[i + n] != 0) {
                    temp[i] += dp[i + n];
                }
            }
            dp = temp;
        }
        return dp[S + sum];
    }
}
