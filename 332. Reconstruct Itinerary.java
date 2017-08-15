Using DFS / Add element in order / return value in recursion function, when we get FIRST true, return directly.
If so, we could terminate the dfs in advance.


Find a path with the number of node is the number of tickets. Allowing a circular path (differ from 339 not
allowing a circular path, so we only remove the edges (not using set))

class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0) {
            return res;
        }
        int len = tickets.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            List<String> cur = map.get(start);
            if (cur == null) {
                cur = new ArrayList<>();
            }
            addInOrder(cur, end);
            map.put(start, cur);
        }
        res.add("JFK");
        dfs(res, map, len);
        return res;
    }
    private boolean dfs(List<String> res, Map<String, List<String>> map, int len) {
        if (res.size() == len + 1) {
            return true;
        }
        List<String> cur = map.get(res.get(res.size() - 1));
        if (cur == null || cur.size() == 0) {
            return false;
        }
        for (int i = 0; i < cur.size(); i++) {
            String s = cur.get(i);
            cur.remove(s);
            res.add(s);
            if (dfs(res, map, len)) {
                return true;
            }
            addInOrder(cur, s);
            res.remove(res.size() - 1);
        }
        return false;
    }
    private void addInOrder(List<String> cur, String s) {
        int i = 0;
        while (i < cur.size()) {
            if (cur.get(i).compareTo(s) > 0) {
                cur.add(i, s);
                return;
            }
            i++;
        }
        cur.add(s);
    }

}
