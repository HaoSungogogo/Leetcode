class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, zero++, one++);
            } else if (nums[one] == 1) {
                one++;
            } else {
                swap(nums, one, two--);
            }
        }
    }
    public void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
