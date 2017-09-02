class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int count = 0;
        int len = M.length;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < M.length; i++) {
           if (!visited[i]) {
               visited[i] = true;
               dfs(M, visited, i);
               count++;
           }
        }
        return count;
    }
    private void dfs(int[][] M, boolean[] visited, int i) {
       for (int j = 0; j < M.length; j++) {
           if (M[i][j] == 1 && !visited[j]) {
               visited[j] = true;
               dfs(M, visited, j);
           }
       }
    }
}
