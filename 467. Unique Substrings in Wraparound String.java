Consider the number of substring ending with certain character. (Using ending character to calculate)
The number is equal to the length of contiguous substring ending with this character.

the string s is wraparoud, it is special, since it is ascending order.

It is similar to find the longest ascending substring.
The value of longest ascending substring on each index is the number of substring ending with this index.

public class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int[] count = new int[26];
        int len = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                len++;
            } else {
                len = 1;
            }
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], len);
        }
        int sum = 0;
        for (int i : count) {
            sum += i;
        }
        return sum;
    }
}

