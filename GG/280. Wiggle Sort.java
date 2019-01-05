Just one traversal, O(n)

class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) {
                    swap(nums, i - 1, i);
                }
            } else {
                if (i != 0 && nums[i] > nums[i - 1]) {
                    swap(nums, i - 1, i);
                }
            }
        }

    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}





Naive Way:

class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = (nums.length + 1) / 2;
        quickSelect(nums, index, 0, nums.length - 1);
        int left = 1;
        int right = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left += 2;
            right -= 2;
        }
    }
    private void quickSelect(int[] nums, int index, int left, int right) {
        int pivot = partition(nums, left, right);
        if (pivot == index) {
            return;
        }
        if (pivot < index) {
            quickSelect(nums, index, pivot + 1, right);
        } else {
            quickSelect(nums, index, left, pivot - 1);
        }
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (nums[i] <= pivot) {
                i++;
            } else if (nums[j] > pivot) {
                j--;
            } else {
                swap(nums, i++, j--);
            }
        }
        swap(nums, i, right);
        return i;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
