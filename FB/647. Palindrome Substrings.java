Every palindrome would have its center, so we could traverse all the situation of center
and expand to both sides.
O(n^2)
O(1)

class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            // i is the center and expand to two sides
            countPalindrome(s, i, i);
            countPalindrome(s, i, i + 1);
        }
        return count;
    }
    private void countPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}


Using Dp
O(n^2)
O(n^2)

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] isP = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
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
