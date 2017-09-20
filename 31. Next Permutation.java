Traverse from end to start, find the descending order location, swap the smallest element larger then this element
in the back.
Then sort the rest.

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int fast = nums.length - 1;
        while (fast >= 1) {
            if (nums[fast] <= nums[fast - 1]) {
                fast--;
            } else {
                int slow = nums.length - 1;
                while (nums[slow] <= nums[fast - 1]) {
                    slow--;
                }
                swap(nums, fast - 1, slow);
                reverse(nums, fast, nums.length - 1);
                break;
            }
        }
        if (fast == 0) {
            reverse(nums, 0, nums.length - 1);
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
