Using QuickSort way.

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
    private int findKthLargest(int[] nums, int start, int end, int k) {
        int index = partition(nums, start, end);
        if (index == nums.length - k) {
            return nums[index];
        } else if (index > nums.length - k) {
            return findKthLargest(nums, start, index - 1, k);
        } else {
            return findKthLargest(nums, index + 1, end, k);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        int j = end - 1;
        while (i <= j) {
            if (nums[i] < pivot) {
                i++;
            } else if (nums[j] >= pivot) {
                j--;
            } else {
                swap(nums, i++, j--);
            }
        }
        swap(nums, i, end);
        return i;
    }
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}



So important, not understand very well
Using binary search, mid is the mid of max and min

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for (int i : nums) {
                if (i >= mid) {
                    count++;
                }
            }
            if (count >= k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }
}
