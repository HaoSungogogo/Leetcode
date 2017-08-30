Using two pointer to maintain leftmax and rightmax, similar to water trap problem.

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int leftmax = 0;
        int rightmax = 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if (leftmax < rightmax) {
                res = Math.max(res, leftmax * (right - left));
                left++;
            } else {
                res = Math.max(res, rightmax * (right - left));
                right--;
            }
        }
        return res;
    }
}
