class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            Integer temp = map.get(c);
            if (temp == null) {
                map.put(c, 1);
            } else {
                map.put(c, temp + 1);
            }
        }
        for (char c : s2.toCharArray()) {
            Integer temp = map.get(c);
            if (temp == null || temp == 0) {
                return false;
            }
            map.put(c, temp - 1);
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
