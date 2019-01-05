Topological Sort -> O(E + V) I think 


Using BFS (using indegree array to judege whether it has cycle)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        buildGraph(prerequisites, numCourses, adj, indegree);
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                qu.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while(!qu.isEmpty()) {
            Integer cur = qu.poll();
            res[index++] = cur;
            for (Integer nei : adj[cur]) {
                if (--indegree[nei] == 0) {
                    qu.offer(nei);
                }
            }
        }
        return index != numCourses ? new int[0] : res;
    }
    private void buildGraph(int[][] prerequisites, int num, List<Integer>[] adj, int[] indegree) {
        for (int i = 0; i < num; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int cur = pair[0];
            adj[prev].add(cur);
            indegree[cur]++;
        }
    }
}

Using dfs (Using visited array to judge whether it has cycle)

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        buildGraph(prerequisites, numCourses, adj);
        int[] visited = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(adj, i, visited, list)) {
                    return new int[0];
                }
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private boolean dfs(List<Integer>[] adj, int i, int[] visited, List<Integer> list) {
        visited[i] = 1;
        for (Integer nei : adj[i]) {
            if (visited[nei] == 1) {
                return false;
            }
            if (visited[nei] == 0) {
                if (!dfs(adj, nei, visited, list)) {
                    return false;
                }
            }
        }
        visited[i] = 2;
        list.add(0, i);
        return true;
    }
    private void buildGraph(int[][] prerequisites, int num, List<Integer>[] adj) {
        for (int i = 0; i < num; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int cur = pair[0];
            adj[prev].add(cur);
        }
    }
}
