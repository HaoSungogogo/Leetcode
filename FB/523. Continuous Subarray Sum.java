The subarray sum -> using prefix sum to solve -> using hashmap could reduct the time for searching
O(n)  -> sum is the multiple of k means have the same mod

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            Integer cur = map.get(sum);
            if (cur != null) {
                if (i - cur > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}

Brute force way: O(n^2)

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
            for (int j = 0; j <= i - 1; j++) {
                int diff = dp[i] - dp[j] + nums[j];
                if (diff == 0 || (k != 0 && diff % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
