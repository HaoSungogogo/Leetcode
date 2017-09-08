class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[slow - 1]) {
                continue;
            } else {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
