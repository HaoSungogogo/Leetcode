Use the special value to mark;
if live and then live, mark as 3 -> 11
if live and then died, mark as 1 -> 01
if died and then live, mark as 2 -> 10
if died and then died, mark as 0 -> 00

if we use board[i][j] & 1
the final result board[i][j] >>= 1

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int num = getLiveNum(board, i, j);
                if (board[i][j] == 1 && num >= 2 && num <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && num == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    private int getLiveNum(int[][] board, int x, int y) {
        int count = 0;
        for (int i = x == 0 ? x : x - 1; i <= (x == board.length - 1 ? x : x + 1); i++) {
            for (int j = y == 0 ? y : y - 1; j <= (y == board[0].length - 1 ? y : y + 1); j++) {
                if ((board[i][j] & 1) == 1) {
                    count++;
                }
            }
        }
        if (board[x][y] == 1) {
            count--;
        }
        return count;
    }
}
