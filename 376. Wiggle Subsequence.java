Naive solution: O(n^2)

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        positive[0] = 1;
        negative[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    positive[i] = Math.max(positive[i], negative[j]);
                } else if (nums[j] > nums[i]) {
                    negative[i] = Math.max(negative[i], positive[j]);
                }
            }
            positive[i]++;
            negative[i]++;
            max = Math.max(max, positive[i]);
            max = Math.max(max, negative[i]);
        }
        return max;
    }
}

Similar to O(n) way of finding acending subsequence
First, find increaing pattern or decreasing pattern.
then traverse acording to this pattern.

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 1;
        while(start < nums.length && nums[start] == nums[start - 1]) {
            start++;
        }
        if (start == nums.length) {
            return 1;
        }
        boolean increasing = nums[start] > nums[0];
        int max = 1;
        int prev = nums[0];
        for (int i = start; i < nums.length; i++) {
            if ((increasing && nums[i] > prev) || (!increasing && nums[i] < prev)) {
                increasing = !increasing;
                max++;
                prev = nums[i];
            }
            prev = nums[i];
        }
        return max;
    }
}
