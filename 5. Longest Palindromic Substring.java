public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return new String();
        }
        int len = s.length();
        char[] array = s.toCharArray();
        boolean[][] isP = new boolean[len][len];
        int max = 0;
        int start = -1;
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (array[i] == array[j]) {
                    isP[i][j] = j - i < 2 || isP[i + 1][j - 1];
                }
                if (isP[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return new String(array, start, max);
    }
}
