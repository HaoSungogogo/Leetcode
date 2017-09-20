We need to consider the situation that the reversed result is overflow,
so when we update the res, we need to check out whether the reverse process could get the same value
if not, return 0.

class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int mod = x % 10;
            int newRes = res * 10 + mod;
            if ((newRes - mod) / 10 != res) {
                return 0;
            }
            res = newRes;
            x /= 10;
        }
        return res;
    }
}
