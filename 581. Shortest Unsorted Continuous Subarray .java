Method 1: 单调栈
          record the first element to break the ascending order from head to tail.
          record the first elemetn to break the descending order from tail to head.

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int left = nums.length;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && array[stack.peekFirst()] > nums[i]) {
                int cur = stack.pollFirst();
                left = Math.min(left, cur);
            }
            stack.offerFirst(i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[stack.peekFirst()] < nums[i]) {
                int cur = stack.pollFirst();
                right = Math.max(right, cur);
            }
            stack.offerFirst(i);
        }
        return right - left + 1 > 0 ? right - left + 1 : 0;
    }
}