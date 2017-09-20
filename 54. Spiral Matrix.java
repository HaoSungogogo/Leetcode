class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        recursion(list, matrix, 0, row, col);
        return list;
    }
    private void recursion(List<Integer> list, int[][] matrix, int offset, int row, int col) {
        if (row == 0 || col == 0) {
            return;
        }
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                list.add(matrix[offset][offset + i]);
            }
            return;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                list.add(matrix[offset + i][offset]);
            }
            return;
        }

        for (int i = 0; i < col - 1; i++) {
            list.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < row - 1; i++) {
            list.add(matrix[offset + i][offset + col - 1]);
        }
        for (int i = col - 1; i > 0; i--) {
            list.add(matrix[offset + row - 1][offset + i]);
        }
        for (int i = row - 1; i > 0; i--) {
            list.add(matrix[offset + i][offset]);
        }
        recursion(list, matrix, offset + 1, row - 2, col - 2);
    }
}
