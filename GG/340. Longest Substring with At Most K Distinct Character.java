class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int fast = 0;
        int slow = 0;
        int max = 0;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            Integer cur = map.get(c);
            if (cur != null) {
                map.put(c, cur + 1);
            } else {
                map.put(c, 1);
            }
            while (map.size() > k) {
                char charOfSlow = s.charAt(slow);
                Integer temp = map.get(charOfSlow);
                if (temp == 1) {
                    map.remove(charOfSlow);
                } else {
                    map.put(charOfSlow, temp - 1);
                }
                slow++;
            }
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        return max;
    }
}
