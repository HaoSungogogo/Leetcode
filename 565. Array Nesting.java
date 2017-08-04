public class Solution {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                continue;
            }
            int temp = nums[i];
            nums[i] = i;
            while (nums[temp] != temp) {
                int cur = nums[temp];
                nums[temp] = temp;
                temp = cur;
                count++;
            }
            max = Math.max(max, count);
            count = 1;
        }
        return max;
    }
}
