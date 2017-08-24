class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        int sum = 0;
        int[] count = new int[]{0};
        dfs(nums, count, 0, size, S);
        return count[0];
    }
    private void dfs(int[] nums, int[] count, int index, int size, int target) {
        if (index == size && target == 0) {
            count[0]++;
            return;
        }
        if (index == size) {
            return;
        }
        dfs(nums, count, index + 1, size, target - nums[index]);
        dfs(nums, count, index + 1, size, target + nums[index]);
    }
}
