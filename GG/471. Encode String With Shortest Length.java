Using two dimentional dp to solve.

class Solution {
    public String encode(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        String[][] dp = new String[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                String substr = s.substring(i, j + 1);
                if (j - i < 4) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    for (int k = i; k < j; k++) {
                        if (dp[i][j].length() > dp[i][k].length() + dp[k + 1][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    for (int m = 0; m < substr.length() - 1; m++) {
                        String temp = substr.substring(0, m + 1);
                        if (substr.length() % temp.length() == 0
                           && substr.replaceAll(temp, "").length() == 0) {
                            String newstr = substr.length() / temp.length() + "[" + dp[i][i + m] + "]";
                            if (newstr.length() < dp[i][j].length()) {
                                dp[i][j] = newstr;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
