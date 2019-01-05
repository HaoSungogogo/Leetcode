class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>(11, new Comparator<Cell>() {
           public int compare(Cell o1, Cell o2) {
               return o1.max - o2.max;
           }
        });
        int res = 0;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        processBorder(heightMap, pq, visited);
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            res += cell.max - heightMap[cell.i][cell.j];
            int i = cell.i;
            int j = cell.j;
            if (i > 0 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                pq.offer(new Cell(i - 1, j, Math.max(cell.max, heightMap[i - 1][j])));
            }
            if (j > 0 && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                pq.offer(new Cell(i, j - 1, Math.max(cell.max, heightMap[i][j - 1])));
            }
            if (i < heightMap.length - 1 && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                pq.offer(new Cell(i + 1, j, Math.max(cell.max, heightMap[i + 1][j])));
            }
            if (j < heightMap[0].length - 1 && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                pq.offer(new Cell(i, j + 1, Math.max(cell.max, heightMap[i][j + 1])));
            }
        }
        return res;
    }
    private void processBorder(int[][] heightMap,  PriorityQueue<Cell> pq, boolean[][] visited) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        for (int i = 0; i < row - 1; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
        }
        for (int i = 0; i < col - 1; i++) {
            pq.offer(new Cell(row - 1, i, heightMap[row - 1][i]));
            visited[row - 1][i] = true;
        }
        for (int i = row - 1; i > 0 ; i--) {
            pq.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
            visited[i][col - 1] = true;
        }
        for (int i = col - 1; i > 0; i--) {
            pq.offer(new Cell(0, i, heightMap[0][i]));
            visited[0][i] = true;
        }
    }
    class Cell {
        int i;
        int j;
        int max;
        public Cell(int i, int j, int max) {
            this.max = max;
            this.i = i;
            this.j = j;
        }
    }
}
