2D dp thinking, only consider [i - 1][j - 1] [i - 1][j] [i][j - 1], similar to longest Common subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int size = s.length();
        char[] array = s.toCharArray();
        int[][] isP = new int[size][size];
        for (int j = 0; j < size; j++) {
            for (int i = j; i >= 0; i--) {
                if (array[i] == array[j]) {
                	if (j - i + 1 < 2) {
                		isP[i][j] = j - i + 1;
                		continue;
                	}
                	isP[i][j] = 2 + isP[i + 1][j - 1];
                }
                int max = Math.max(isP[i][j - 1], isP[i + 1][j]);
                isP[i][j] = Math.max(isP[i][j], max);
            }
        }
        return isP[0][size - 1];
    }
}
