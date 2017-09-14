public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = (n & 1);
        for (int i = 0; i < 31; i++) {
            count += ((n >> 1) & 1);
            n >>= 1;
        }
        return count;
    }
}
