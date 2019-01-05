Naive DFS way:

class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));
            }
        }
        for (String str : list) {
            if (!canWin(str)) {
                return true;
            }
        }
        return false;
    }
}

Using Memoization to solve it.


class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, map);
    }
    private boolean dfs(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));
            }
        }
        for (String str : list) {
            if (!dfs(str, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }








}
