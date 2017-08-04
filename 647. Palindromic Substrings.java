maintain palindrome table to count.

public class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int count = 0;
        boolean[][] isP = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    isP[i][j] = j - i < 2 || isP[i + 1][j - 1];
                }
                if (isP[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
