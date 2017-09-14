class Solution {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    dfs(board, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || board[i][j] != 'X') {
            return;
        }
        visited[i][j] = true;
        dfs(board, visited, i + 1, j);
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i, j + 1);
        dfs(board, visited, i, j - 1);
    }
}
