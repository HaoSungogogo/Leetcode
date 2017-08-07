Using recursion, cutting two sides with the character less than k time
For every recursion, we all construct the bitMap. 

public class Solution {
    public int longestSubstring(String s, int k) {
        char[] array = s.toCharArray();
        return recursion(array, 0, array.length - 1, k);
    }
    private int recursion(char[] array, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }
        int[] map = new int[26];
        for (int i = left; i <= right; i++) {
            int index = array[i] - 'a';
            map[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0 && map[i] < k) {
                for (int j = left; j <= right; j++) {
                    if (array[j] == 'a' + i) {
                        int leftval = recursion(array, left, j - 1, k);
                        int rightval = recursion(array, j + 1, right, k);
                        return Math.max(leftval, rightval);
                    }
                }
            }
        }
        return right - left + 1;
    }
}
