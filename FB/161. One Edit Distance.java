class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == t.length()) {
            return oneModify(s, t);
        } if (s.length() > t.length()) {
            return oneDelete(s, t);
        } else {
            return oneDelete(t, s);
        }
    }
    private boolean oneModify(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        return false;
    }
    private boolean oneDelete(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i));
            }
        }
        return s.length() - t.length() == 1;
    }
}
