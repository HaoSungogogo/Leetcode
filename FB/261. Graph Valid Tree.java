class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        buildGraph(edges, adj);
        int[] visited = new int[n];
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(0);
        visited[0] = 1;
        while (!qu.isEmpty()) {
            Integer cur = qu.poll();
            visited[cur] = 2;
            for (Integer nei : adj[cur]) {
                if (visited[nei] == 1) {
                    return false;
                }
                if (visited[nei] == 0) {
                    qu.offer(nei);
                    visited[nei] = 1;
                }
            }
        }
        for (int i : visited) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
    private void buildGraph(int[][] edges, List<Integer>[] adj) {
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pair : edges) {
            int one = pair[0];
            int two = pair[1];
            adj[one].add(two);
            adj[two].add(one);
        }
    }
}



class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        buildGraph(edges, adj);
        int[] visited = new int[n];
        if (!dfs(0, -1, adj, visited)) {
            return false;
        }
        for (int i : visited) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int cur, int pre, List<Integer>[] adj, int[] visited) {
        visited[cur] = 1;
        for (Integer nei : adj[cur]) {
            if (nei != pre && visited[nei] == 1) {
                return false;
            }
            if (visited[nei] == 0) {
                if (!dfs(nei, cur, adj, visited)) {
                    return false;
                }
            }
        }
        visited[cur] = 2;
        return true;
    }
    private void buildGraph(int[][] edges, List<Integer>[] adj) {
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pair : edges) {
            int one = pair[0];
            int two = pair[1];
            adj[one].add(two);
            adj[two].add(one);
        }
    }
}
