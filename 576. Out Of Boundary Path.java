DFS: it would be exceed time limit

class Solution {
    private int mod = 1000000007;
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int findPaths(int m, int n, int N, int i, int j) {
        int[] path = new int[]{0};
        dfs(path, i, j, N, m, n);
        return path[0];
    }
    private void dfs(int[] path, int i, int j, int N, int row, int col) {
        if (N == 0) {
            return;
        }
        for (int[] d : dir) {
            if (check(i, j, row, col, d)) {
                path[0]++;
                path[0] = path[0] % mod;
            } else {
                dfs(path, i + d[0], j + d[1], N - 1, row, col);
            }
        }
    }
    private boolean check(int i, int j, int row, int col, int[] d) {
        i += d[0];
        j += d[1];
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return true;
        }
        return false;
    }
}

DP way: it is 3D dp
for every version of count represents the number of way to get to certain location in certain step.


class Solution {
    private int mod = 1000000007;
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int findPaths(int m, int n, int N, int i, int j) {
        int res = 0;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        for (int k = 0; k < N; k++) {
            int[][] temp = new int[m][n];    // 3D Dp
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (count[x][y] != 0) {
                        for (int[] d : dir) {
                            int nx = x + d[0];
                            int ny = y + d[1];
                            if (check(nx, ny, m, n)) {
                                res = (res + count[x][y]) % mod;
                            } else {
                                temp[nx][ny] = (temp[nx][ny] + count[x][y]) % mod;
                            }
                        }
                    }
                }
            }
            count = temp;
        }
        return res;
    }

    private boolean check(int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return true;
        }
        return false;
    }
}
