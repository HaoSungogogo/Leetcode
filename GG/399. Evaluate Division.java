class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        Map<String, List<Edge>> map = new HashMap<>();
        buildGraph(map, equations, values);
        for (int i = 0; i < queries.length; i++) {
            String start = queries[i][0];
            String end = queries[i][1];
            Set<String> path = new HashSet<>();
            res[i] = dfs(start, end, map, 1, path);
        }
        return res;
    }
    private void buildGraph(Map<String, List<Edge>> map, String[][] equations, double[] values) {
        int len = equations.length;
        for (int i = 0; i < len; i++) {
            String one = equations[i][0];
            String two = equations[i][1];
            List<Edge> l1 = map.get(one);
            if (l1 == null) {
                l1 = new ArrayList<Edge>();
                map.put(one, l1);
            }
            l1.add(new Edge(two, values[i]));

            List<Edge> l2 = map.get(two);
            if (l2 == null) {
                l2 = new ArrayList<Edge>();
                map.put(two, l2);
            }
            l2.add(new Edge(one, 1 / values[i]));
        }
    }
    private double dfs(String start, String end, Map<String, List<Edge>> map, double preVal, Set<String> path) {
        if (!map.containsKey(start) || !map.containsKey(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return preVal;
        }
        List<Edge> edges = map.get(start);
        for (Edge e : edges) {
            if (path.add(e.end)) {
                double res = dfs(e.end, end, map, preVal * e.weight, path);
                if (res != -1) {
                    return res;
                }
            }
        }
        return -1;
    }

    class Edge{
        String end;
        double weight;
        public Edge(String end, double weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
