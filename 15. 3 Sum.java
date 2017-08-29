similar to 2 sum and fix a location and run two pointer 2 sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
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
                if (val == 0) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                } else if (val > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
