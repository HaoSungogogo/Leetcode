Quick Sort thinking.
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k , 0, nums.length - 1);
    }
    private int findKthLargest(int[] nums, int k, int left, int right) {
        int index = partition(nums, left, right);
        if (index == k - 1) {
            return nums[index];
        }
        if (index < k - 1) {
            return findKthLargest (nums, k, index + 1, right);
        } else {
            return findKthLargest (nums, k, left, index - 1);
        }
    }

    private int partition (int[] nums, int left, int right) {
        int pivot = nums[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (nums[start] > pivot) {
                start++;
            } else if (nums[end] <= pivot) {
                end--;
            } else {
                swap(nums, start++, end--);
            }
        }
        swap(nums, start, right);
        return start;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
