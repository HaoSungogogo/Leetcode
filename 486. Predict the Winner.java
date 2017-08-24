class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int size = nums.length;
        int[][] dp = new int[size][size];
        for (int j = 0; j < size; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else if (j - i == 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    int val1 = Math.min(dp[i + 2][j], dp[i + 1][j - 1]) + nums[i];
                    int val2 = Math.min(dp[i][j - 2], dp[i + 1][j - 1]) + nums[j];
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
        int count = 0;
        for (int i : nums) {
            count += i;
        }
        return dp[0][size - 1] >= (count - dp[0][size - 1]);
    }
}
The problem want:
Whatever the player2 choose, the player1 always win. So we calculate the max player1 gets would
larger than half of total sum. Player1 would win.
So for choose i and choose j, we want get max choice.
But, more importantly, in every choice i or j, since we do not know player1 choose what, so we assume player1
also want to get max, then we need get min in each situation.
