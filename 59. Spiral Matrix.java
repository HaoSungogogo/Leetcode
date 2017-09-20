class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        recursion(res, 1, 0, n);
        return res;
    }
    private void recursion(int[][] matrix, int num, int offset, int size) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
        	matrix[offset][offset] = num;
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            matrix[offset][offset + i] = num++;
        }
        for (int i = 0; i < size - 1; i++) {
            matrix[offset + i][offset + size - 1] = num++;
        }
        for (int i = size - 1; i > 0; i--) {
            matrix[offset + size - 1][offset + i] = num++;
        }
        for (int i = size - 1; i > 0; i--) {
            matrix[offset + i][offset] = num++;
        }
        recursion(matrix, num, offset + 1, size - 2);
    }
}
