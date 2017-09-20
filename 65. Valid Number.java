public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return false;
        }
        String regex = "[-+]?([0-9]+\\.?|\\.[0-9]+)[0-9]*([eE][-+]?[0-9]+)?";
        return trimmed.matches(regex);
    }
}
