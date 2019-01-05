From the edge of pacific and atlantic to expand
if certain cell could be generated, which means that it could have ocean

class Solution {
    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<int[]> pqu = new LinkedList<>();
        Queue<int[]> aqu = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            pacific[i][0] = true;
            atlantic[i][col - 1] = true;
            pqu.offer(new int[]{i, 0});
            aqu.offer(new int[]{i, col - 1});
        }
        for (int i = 0; i < col; i++) {
            pacific[0][i] = true;
            atlantic[row - 1][i] = true;
            pqu.offer(new int[]{0, i});
            aqu.offer(new int[]{row - 1, i});
        }
        bfs(aqu, atlantic, matrix);
        bfs(pqu, pacific, matrix);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;
    }
    private void bfs(Queue<int[]> qu, boolean[][] visited, int[][] matrix) {
    	int row = matrix.length;
        int col = matrix[0].length;
        while(!qu.isEmpty()) {
            int[] pair = qu.poll();
            for (int[] d : dir) {
                int x = pair[0] + d[0];
                int y = pair[1] + d[1];
                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y] && matrix[x][y] >= matrix[pair[0]][pair[1]]) {
                    visited[x][y] = true;
                    qu.offer(new int[]{x, y});
                }
            }
        }
    }
}
