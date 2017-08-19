class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int local = 0;
        for (int i = 0; i< nums.length; i++) {
            if (local > 0) {
                local += nums[i];
            } else {
                local = nums[i];
            }
            max = Math.max(max, local);
        }
        return max;
    }
}
