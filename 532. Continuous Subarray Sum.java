Pay attention to the corner case: when diff == 0, all are true
k == 0 situation

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] += dp[i - 1] + nums[i - 1];
            for (int j = 0; j <= i - 2; j++) {
                int dif = dp[i] - dp[j];
                if (dif == 0) {
                    return true;
                }
                if (k != 0 && dif % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
