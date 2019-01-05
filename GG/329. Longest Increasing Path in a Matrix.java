Dfs + memoization
Time: O(mn)
Space: O(mn)

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] cache = new int[row][col];
        int res = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, dfs(i, j, matrix, cache, Integer.MIN_VALUE));
            }
        }
        return res;
    }
    private int dfs(int i, int j, int[][] matrix, int[][] cache, int pre) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || pre >= matrix[i][j]) {
            return 0;
        }
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        int temp = 0;
        temp = Math.max(temp, dfs(i + 1, j, matrix, cache, matrix[i][j]));
        temp = Math.max(temp, dfs(i - 1, j, matrix, cache, matrix[i][j]));
        temp = Math.max(temp, dfs(i, j + 1, matrix, cache, matrix[i][j]));
        temp = Math.max(temp, dfs(i, j - 1, matrix, cache, matrix[i][j]));
        cache[i][j] = ++temp;
        return cache[i][j];
    }
}
