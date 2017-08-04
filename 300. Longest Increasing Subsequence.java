O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int global = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            global = Math.max(global, dp[i]);
        }
        return global;
    }
}

O(nlogn) improve the result for each step and using binary search to find the element (smallestLargestOrEqual)
return the length of result

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] bs = new int[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if (index == 0 || nums[i] > bs[index - 1]) {
                bs[index++] = nums[i];
            } else {
                int replaceIndex = smallestLargerOrEqual(bs, index - 1, nums[i]);
                bs[replaceIndex] = nums[i];
            }
        }
        return index;
    }
    private int smallestLargerOrEqual(int[] bs, int right, int target) {
        int left = 0;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target <= bs[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (bs[left] >= target) {
            return left;
        } else {
            return right;
        }
    }
}
