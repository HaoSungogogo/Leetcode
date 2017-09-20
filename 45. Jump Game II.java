Using the thought of BFS.

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int curmax = nums[0];
        int level = 1;
        int i = 1;
        if (curmax >= nums.length - 1) {
            return level;
        }
        while (i <= curmax) {
            int localmax = 0;
            for (;i <= curmax; i++) {
                localmax = Math.max(localmax, i + nums[i]);
                if (localmax >= nums.length - 1) {
                    return level + 1;
                }
            }
            curmax = localmax;
            level++;
        }
        return 0;
    }
}
