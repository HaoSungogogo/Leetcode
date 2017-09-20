For the positive array, the first lost number must be in [1, nums.length], so when we parition the positive
element, the rest of work is the same with missing positive element.

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int count = partition(nums);
        for (int i = 0; i < count; i++) {
            int cur = Math.abs(nums[i]);
            if (cur <= count) {
                nums[cur - 1] = nums[cur - 1] < 0 ? nums[cur - 1] : -nums[cur - 1];
            }
        }
        int res = count;
        for (int i = 0; i < count; i++) {
            if (nums[i] > 0) {
                res = i;
                break;
            }
        }
        return res + 1;
    }
    private int partition(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] > 0) {
                left++;
            } else if (nums[right] <= 0) {
                right--;
            } else {
                swap(nums, left++, right--);
            }
        }
        return left;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
