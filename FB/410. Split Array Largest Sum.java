The result must be in the range between max from sum, since it is non-negative.
So we could binary search (max - sum)

class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (m == 1) {
            return sum;
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(mid, nums, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean valid(int mid, int[] nums, int m) {
        int count = 1;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum > mid) {
                count++;
                sum = i;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}



Using Dp
dp[i][j] represents the minimal largest sum among i + 1 sub-arrays for the first j + 1 elements.

class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[m][nums.length];
        dp[0][0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[0][i - 1] + nums[i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = i; j < nums.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i - 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], dp[0][j] - dp[0][k]));
                }
            }
        }
        return dp[m - 1][nums.length - 1];
    }
}
