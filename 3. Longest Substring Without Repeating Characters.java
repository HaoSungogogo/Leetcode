class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int slow = 0;
        Set<Character> set = new HashSet<>();
        set.add(array[0]);
        int max = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (!set.add(array[fast])) {
                while(array[slow] != array[fast]) {
                    set.remove(array[slow++]);
                }
                slow++;
            } else {
                max = Math.max(max, fast - slow + 1);
            }
        }
        return max;
    }
}
