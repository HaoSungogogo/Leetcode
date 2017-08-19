Maintain two dp array, the one contains the current value, the one does not contain the current value;
Two dp array!!!!

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int contain = 0;
        int noncontain = 0;
        for (int i = 0; i < nums.length; i++) {
            int localcontain = nums[i] + noncontain;
            noncontain = Math.max(noncontain, contain);
            contain = localcontain;
        }
        return Math.max(noncontain, contain);
    }
}
