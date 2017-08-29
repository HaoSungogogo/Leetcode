class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int slen = s.length();
        int plen = p.length();
        char[] sarr = s.toCharArray();
        char[] parr = p.toCharArray();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for (int i = 1; i < plen + 1; i++) {
            if (i == 1) {
                if (parr[i - 1] == '*') {
                    dp[0][i] = true;
                }
            } else {
                dp[0][i] = dp[0][i - 2] && parr[i - 1] == '*';
            }
        }
        for (int i = 1; i < slen + 1; i++) {
            for (int j = 1; j < plen + 1; j++) {
                if (parr[j - 1] == sarr[i - 1] || parr[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (parr[j - 1] == '*') {
                    if (parr[j - 2] != sarr[i - 1] && parr[j - 2] != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[slen][plen];
    }
}
