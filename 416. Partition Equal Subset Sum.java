DFS but time exceed limit

class Solution {
    public boolean canPartition(int[] nums) {
        int count = 0;
        for (int i : nums) {
            count += i;
        }
        if (count % 2 != 0) {
            return false;
        } else {
            return dfs(nums, 0, count / 2);
        }
    }
    private boolean dfs(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        boolean res = false;
        for (int i = index; i < nums.length; i++) {
            if (target >= nums[i]) {
                res = res || dfs(nums, i + 1, target - nums[i]);
            }
        }
        return res;
    }
}

DP way: using 2D x : element, y : the value.
class Solution {
    public boolean canPartition(int[] nums) {
        int count = 0;
        for (int i : nums) {
            count += i;
        }
        if (count % 2 != 0) {
            return false;
        }
        int target = count / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
