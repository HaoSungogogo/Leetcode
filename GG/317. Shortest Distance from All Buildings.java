O(number of 1)O(number of 0) ~ O(m^2n^2)
O(n^2)
class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] times = new int[row][col];
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    num++;
                    bfs(distance, i, j, grid, times);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && times[i][j] == num) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }
        return min = min == Integer.MAX_VALUE ? -1 : min;
    }
    private void bfs(int[][] distance, int i, int j, int[][] grid, int[][] times) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int weight = 0;
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(i, j));
        visited[i][j] = true;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int k = 0; k < size; k++) {
                Pair pair = qu.poll();
                int x = pair.i;
                int y = pair.j;
                distance[x][y] += weight;
                times[x][y]++;
                if (check(x - 1, y, grid, visited)) {
                    qu.offer(new Pair(x - 1, y));
                    visited[x - 1][y] = true;
                }
                if (check(x + 1, y, grid, visited)) {
                    qu.offer(new Pair(x + 1, y));
                    visited[x + 1][y] = true;
                }
                if (check(x, y - 1, grid, visited)) {
                    qu.offer(new Pair(x, y - 1));
                    visited[x][y - 1] = true;
                }
                if (check(x, y + 1, grid, visited)) {
                    qu.offer(new Pair(x, y + 1));
                    visited[x][y + 1] = true;
                }
            }
            weight++;
        }
    }
    private boolean check(int i, int j, int[][] grid, boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;
        if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == 0 && !visited[i][j]) {
            return true;
        } else {
            return false;
        }
    }

    class Pair{
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
