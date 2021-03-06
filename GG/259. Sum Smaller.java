class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int val = nums[i] + nums[left] + nums[right];
                if (val >= target) {
                    right--;
                } else {
                    count += right - left;
                    left++;
                }
            }
        }
        return count;
    }
}
