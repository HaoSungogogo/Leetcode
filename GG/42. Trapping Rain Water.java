class Solution {
    public int trap(int[] height) {
        //Using DP
        //O(n) time and O(n) space
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = 0;
        rightMax[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            rightMax[height.length - 1 - i] = Math.max(rightMax[height.length - i], height[height.length - i]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(rightMax[i], leftMax[i]);
            if (temp > height[i]) {
                res += temp - height[i];
            }
        }
        return res;
    }
}

Two pointer.

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int leftmax = 0;
        int rightmax = 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left <= right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if (leftmax <= rightmax) {
                res += leftmax - height[left];
                left++;
            }  else {
                res += rightmax - height[right];
                right--;
            }
        }
        return res;
    }
}
