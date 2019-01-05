class Solution {
    private int[][] jumps;
    private boolean[] visited;
    public int numberOfPatterns(int m, int n) {
        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = 5;
        jumps[7][3] = jumps[3][7] = 5;
        visited = new boolean[10];
        int[] count = new int[]{0, 0, 0};
        dfs(1, m, n, 1, count, 0);
        dfs(2, m, n, 1, count, 1);
        dfs(5, m, n, 1, count, 2);
        return count[0] * 4 + count[1] * 4 + count[2];
    }
    private void dfs(int start, int m, int n, int len, int[] count, int flag) {
        if (len >= m && len <= n) {
            count[flag]++;
            if (len == n) {
                return;
            }
        }
        visited[start] = true;
        for (int next = 1; next <= 9; next++) {
            if (!visited[next] && (jumps[start][next] == 0 || visited[jumps[start][next]])) {
                dfs(next, m, n, len + 1, count, flag);
            }
        }
        visited[start] = false;
    }
}
