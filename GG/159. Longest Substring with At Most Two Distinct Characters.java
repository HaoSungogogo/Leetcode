class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (fast < s.length()) {
            char c = s.charAt(fast);
            Integer cur = map.get(c);
            if (cur == null) {
                map.put(c, 1);
            } else {
                map.put(c, cur + 1);
            }

            while (map.size() > 2) {
                char cSlow = s.charAt(slow);
                Integer temp = map.get(cSlow);
                if (temp > 1) {
                    map.put(cSlow, temp - 1);
                } else {
                    map.remove(cSlow);
                }
                slow++;
            }
            res = Math.max(res, fast - slow + 1);
            fast++;
        }
        return res;
    }
}
