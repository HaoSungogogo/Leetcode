public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            res |= (sum << i);
        }
        return res;
    }
}

Way of thinking: int has 32 bits, we calculate every bit sum to mod 3, we will get the certain number on this single number.