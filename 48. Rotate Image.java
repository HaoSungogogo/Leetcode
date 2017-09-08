class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int size = matrix.length;
        recursion(matrix, 0, size);
    }
    private void recursion(int[][] matrix, int offset, int size) {
        if (size <= 0) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            int temp = matrix[offset][i + offset];
            matrix[offset][i + offset] = matrix[offset + size - 1 - i][offset];
            matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1][offset + size - 1 - i];
            matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + i][offset + size - 1];
            matrix[offset + i][offset + size - 1] = temp;
        }
        recursion(matrix, offset + 1, size - 2);
    }
}
