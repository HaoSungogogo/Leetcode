It is a graph problem, first we need construct a graph.

The way of thinking is to find the path from start to end.
Run dfs for each query and construct a set to record to avoid duplicate.
DFS function return the value.


class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int len = values.length;
        double[] res = new double[queries.length];
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String start = equations[i][0];
            String end = equations[i][1];
            List<Pair> cur = map.get(start);
            List<Pair> cur1 = map.get(end);
            if (cur == null) {
                cur = new ArrayList<Pair>();
            }
            if (cur1 == null) {
                cur1 = new ArrayList<Pair>();
            }
            cur.add(new Pair(end, values[i]));
            cur1.add(new Pair(start, 1 / values[i]));
            map.put(start, cur);
            map.put(end, cur1);
        }
        for (int i = 0; i < queries.length; i++) {
            String start = queries[i][0];
            String end = queries[i][1];
            Set<String> set = new HashSet<>();
            res[i] = dfs(start, end, map, 1.0, set);
        }
        return res;
    }
    private double dfs(String start, String end, Map<String, List<Pair>> map, double preSum, Set<String> set) {
        List<Pair> list = map.get(start);
        if (list == null) {
            return -1;
        }
        if (start.equals(end)) {
            return preSum;
        }
        set.add(start);
        int i = 0;
        while (i < list.size()) {
            Pair pair = list.get(i);
            if (!set.contains(pair.end)) {
                double res = dfs(pair.end, end, map, preSum * pair.weight, set);
                if (res != -1) {
                    return res;
                }
            }
            i++;
        }
        return -1;
    }

    class Pair {
        String end;
        double weight;
        public Pair (String end, double weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
