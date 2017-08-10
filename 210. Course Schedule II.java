public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        int[] res = new int[numCourses];
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
        int index = numCourses - 1;
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                qu.offer(i);
            }
        }
        while (!qu.isEmpty()) {
            Integer cur = qu.poll();
            res[index--] = cur;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[cur][i] != 0) {
                    if (--indegree[i] == 0) {
                        qu.offer(i);
                    }
                }
            }
        }
        if (index >= 0) {
            return new int[0];
        } else {
            return res;
        }
    }
}
