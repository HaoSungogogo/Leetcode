class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        char c = s.charAt(0);
        if (c == '0') {
            dp[1] = 0;
        } else if (c == '*') {
            dp[1] = 9;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);

            // dp[i - 1]
            if (second == '*') {
                dp[i] += 9 * dp[i - 1];
            } else if (second != '0') {
                dp[i] += dp[i - 1];
            }

            //dp[i - 2]
            if (first == '*') {
                if (second == '*') {
                    dp[i] += 15 * dp[i - 2];
                } else if (second <= '6') {
                    dp[i] += 2 * dp[i - 2];
                } else {
                    dp[i] += dp[i - 2];
                }
            } else {
                if (first == '1' || first == '2') {
                    if (second == '*') {
                        if (first == '1') {
                            dp[i] += 9 * dp[i - 2];
                        } else {
                            dp[i] += 6 * dp[i - 2];
                        }
                    } else {
                        int val = (first - '0') * 10 + second - '0';
                        if (val >= 10 && val <= 26) {
                            dp[i] += dp[i - 2];
                        }
                    }
                }
            }
            dp[i] %= 1000000007;
        }
        return (int)dp[s.length()];
    }
}
