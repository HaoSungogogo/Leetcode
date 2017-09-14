Two Pointer:
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= s) {
                min = Math.min(min, fast - slow + 1);
                sum -= nums[slow++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

Using binarysearch, since we do not sort the original array, getting prefix sum is in ascending order.
After having this order, we could using binary search. target = prefix[i - 1] + s

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < prefix.length - 1; i++) {
            int index = binarysearch(i, prefix.length - 1, prefix, prefix[i - 1] + s);
            if (index == prefix.length) {
                break;
            }
            min = Math.min(min, index - i + 1);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    private int binarysearch(int left, int right, int[] prefix, int target) {
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (prefix[left] >= target) {
            return left;
        } else if (prefix[right] < target) {
            return right + 1;
        } else {
            return right;
        }
    }
}
