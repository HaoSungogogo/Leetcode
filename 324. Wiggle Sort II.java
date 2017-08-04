Find kth largest element combine with rainbow sort.

public class Solution {
    public void wiggleSort(int[] nums) {
        int num = (nums.length + 1) / 2;
        int mid = findKthSmallest(nums, num);
        int odd = 1;
        int even = (nums.length - 1) / 2 * 2;    //// last even index
        while (odd < nums.length && end >= 0) {
            if(nums[odd] > mid) {
                odd += 2;
            } else if (nums[even] < mid) {
                even -= 2;
            } else {
                swap(nums, even, odd);
                odd += 2;
                even -= 2;
            }
        }
    }    
     private int findKthSmallest(int[] nums, int k) {
        return findKthSmallest(nums, k , 0, nums.length - 1);
    }
    private int findKthSmallest(int[] nums, int k, int left, int right) {
        int index = partition(nums, left, right);
        if (index == k - 1) {
            return nums[index];
        }
        if (index < k - 1) {
            return findKthSmallest (nums, k, index + 1, right);
        } else {
            return findKthSmallest (nums, k, left, index - 1);
        }
    }
    
    private int partition (int[] nums, int left, int right) {
        int pivot = nums[right];
        int start = left; 
        int end = right - 1;
        while (start <= end) {
            if (nums[start] <= pivot) {
                start++;
            } else if (nums[end] > pivot) {
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