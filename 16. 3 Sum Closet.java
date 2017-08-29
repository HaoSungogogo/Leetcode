class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int diff = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int val = nums[left] + nums[right] + nums[i];
                if (Math.abs(val - target) < diff) {
                    diff = Math.abs(val - target);
                    res = val;
                }
                if (val == target) {
                    return res;
                } else if (val > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
