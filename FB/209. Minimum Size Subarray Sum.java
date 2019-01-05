prefix sum + binary search O(nlogn)

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int index = binarySearch(prefix, i + 1, prefix.length - 1, prefix[i] + s);
            if (index != -1) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    private int binarySearch(int[] prefix, int left, int right, int target) {
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
        }
        if (prefix[right] < target) {
            return -1;
        }
        return right;
    }
}

O(n) -> 666 de two pointer.


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int fast = 0;
        int slow = 0;
        int min = Integer.MAX_VALUE;
        while (fast < nums.length) {
            sum += nums[fast++];
            while (sum >= s) {
                min = Math.min(min, fast - slow);
                sum -= nums[slow++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
