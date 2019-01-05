Using bfs. O(mn)
This problem is not to get the min distance to all gates, so we do not need to run bfs on each gates once.
This problem is to get min distance to any gates, so we run bfs for the gates at the same time.
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Pair> qu = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    qu.offer(new Pair(i, j));
                }
            }
        }
        while(!qu.isEmpty()) {
            int size = qu.size();
            for (int k = 0; k < size; k++) {
                Pair pair = qu.poll();
                if (pair.x > 0 && rooms[pair.x - 1][pair.y] == Integer.MAX_VALUE) {
                    rooms[pair.x - 1][pair.y] = rooms[pair.x][pair.y] + 1;
                    qu.offer(new Pair(pair.x - 1, pair.y));
                }
                if (pair.x < row - 1 && rooms[pair.x + 1][pair.y] == Integer.MAX_VALUE) {
                    rooms[pair.x + 1][pair.y] = rooms[pair.x][pair.y] + 1;
                    qu.offer(new Pair(pair.x + 1, pair.y));
                }
                if (pair.y > 0 && rooms[pair.x][pair.y - 1] == Integer.MAX_VALUE) {
                    rooms[pair.x][pair.y - 1] = rooms[pair.x][pair.y] + 1;
                    qu.offer(new Pair(pair.x, pair.y - 1));
                }
                if (pair.y < col - 1 && rooms[pair.x][pair.y + 1] == Integer.MAX_VALUE) {
                    rooms[pair.x][pair.y + 1] = rooms[pair.x][pair.y] + 1;
                    qu.offer(new Pair(pair.x, pair.y + 1));
                }
            }
        }
    }
    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
