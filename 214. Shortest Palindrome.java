Naive Solution: O(n^2)

class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] array = s.toCharArray();
        int index = 0;
        for(int i = 1; i < array.length; i++) {
            if (isP(array, 0, i)) {
                index = Math.max(index, i);
            }
        }
        index++;
        StringBuilder sb = new StringBuilder();
        if (index == array.length) {
            return s;
        }
        for (int j = array.length - 1; j >= index; j--) {
            sb.append(array[j]);
        }
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }
    private boolean isP (char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


KMP way : O(n), continue...... 
