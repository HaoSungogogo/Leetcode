class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int oneCount = 0;
            for (int n : nums) {
                oneCount += ((n >> i) & 1);
            }
            count += oneCount * (len - oneCount);
        }
        return count;
    }
}
