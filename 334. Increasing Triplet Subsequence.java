class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= min) {
                min = i;
            } else if (i <= secondmin) {
                secondmin = i;
            } else {
                return true;
            }
        }
        return false;
    }
}
