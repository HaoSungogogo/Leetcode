My own way using dfs, I do not think it is a good solution.

Use an adjacent list to construct the graph, no need using map.

Using DFS to search the circle

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null && prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = getFakeGraph(prerequisites);
        System.out.println(map);
        Set<Integer> set = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!set.contains(i)) {
                if (!dfs(map, set, path, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> set, Set<Integer> path, int start) {
    	  set.add(start);
        path.add(start);
        List<Integer> neighbors = map.get(start);

        if (neighbors == null) {
            path.remove(start);
            return true;
        }
        boolean res = true;
        for (Integer nei : neighbors) {
            if (path.contains(nei)) {
                return false;
            }
            res = res && dfs(map, set, path, nei);
        }
        path.remove(start);
        return res;
    }

    private Map<Integer, List<Integer>> getFakeGraph (int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> cur = map.get(prerequisites[i][0]);
            if (cur == null) {
                cur = new ArrayList<>();
            }
            cur.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], cur);
        }
        return map;
    }
}

Using BFS and Topological Sort -> the vertex could be traverse in order if it does not have circle
Maintain an indegree array, when the indegree of vertex decreases to 0, add it


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null && prerequisites.length == 0) {
            return true;
        }
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[ready][pre] == 0) {
                indegree[pre]++;
            }
            matrix[ready][pre] = 1;
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                qu.offer(i);
            }
        }
        int count = 0;
        while(!qu.isEmpty()) {
            Integer cur = qu.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[cur][i] != 0) {
                    if (--indegree[i] == 0) {
                        qu.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
