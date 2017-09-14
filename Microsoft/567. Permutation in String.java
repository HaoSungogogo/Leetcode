class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        char[] array = s2.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
        }
        int count = len1;
        int slow = 0;
        int fast = 0;
        while (fast < len2) {
            if (map[array[fast++] - 'a']-- > 0) {
                count--;
            }
            while (count == 0) {
                if (fast - slow == len1) {
                    return true;
                }
                if (map[array[slow++] - 'a']++ == 0) {
                    count++;
                }
            }
        }
        return false;
    }
}
