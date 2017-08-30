class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        char[] array = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (board[i][j] == array[0]) {
                    if (dfs(array, board, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[] array, char[][] board, boolean[][] visited, int i, int j, int index) {
        if (index == array.length) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != array[index] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(array, board, visited, i + 1, j, index + 1) || dfs(array, board, visited, i - 1, j, index + 1)
                   || dfs(array, board, visited, i, j + 1, index + 1) || dfs(array, board, visited, i, j - 1, index + 1);
        visited[i][j] = false;
        return res;
    }
}
