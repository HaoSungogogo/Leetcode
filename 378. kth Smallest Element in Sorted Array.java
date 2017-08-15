public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            public int compare(Element o1, Element o2) {
                if (o1.val == o2.val) {
                    return 0;
                }
                return o1.val < o2.val ? -1 : 1;
            }
        });
        pq.offer(new Element(matrix[0][0], 0, 0));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Element cur = pq.poll();
            if (cur.row + 1 < row && !visited[cur.row + 1][cur.col]) {
                pq.offer(new Element(matrix[cur.row + 1][cur.col], cur.row + 1, cur.col));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col + 1 < col && !visited[cur.row][cur.col + 1]) {
                pq.offer(new Element(matrix[cur.row][cur.col + 1], cur.row, cur.col + 1));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        return pq.peek().val;
    }
    class Element {
        int val;
        int row;
        int col;
        public Element(int val, int row, int col) {
            this.val = val;
            this.col = col;
            this.row = row;
        }
    }
}
