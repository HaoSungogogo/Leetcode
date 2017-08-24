Ugly code that I have seen

class Solution {
    public int rob(int[] nums) {
        int[] zero = new int[]{0, 0};
        int[] one = new int[]{0, 0};
        for(int i = 0; i < nums.length; i++) {
            int[] newZero = new int[2];
            int[] newOne = new int[2];
            if (i == 0) {
                newZero[0] = nums[i] + zero[1];
                newZero[1] = Math.max(zero[0], zero[1]);
                zero = newZero;
            } else if (i == nums.length - 1) {
                newOne[0] = nums[i] + one[1];
                newOne[1] = Math.max(one[0], one[1]);
                one = newOne;
            } else {
                newZero[0] = nums[i] + zero[1];
                newZero[1] = Math.max(zero[0], zero[1]);
                zero = newZero;
                newOne[0] = nums[i] + one[1];
                newOne[1] = Math.max(one[0], one[1]);
                one = newOne;
            }
        }
        int max1 = Math.max(zero[0], zero[1]);
        int max2 = Math.max(one[0], one[1]);
        return Math.max(max1, max2);
    }
}
