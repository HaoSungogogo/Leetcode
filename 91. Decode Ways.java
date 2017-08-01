public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = array[0] == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            if (array[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            int val = (array[i - 2] - '0') * 10 + array[i - 1] - '0';
            if (val >= 10 && val <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}