Run two binary search, the first bs is to find the rotate index, the other is normal binary search.

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int rot = left;
        if (rot == 0) {
            return bfs(nums, 0, nums.length - 1, target);
        }
        if (target < nums[0]) {
            return bfs(nums, rot, nums.length - 1, target);
        } else {
            return bfs(nums, 0, rot - 1, target);
        }
    }
    private int bfs(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
