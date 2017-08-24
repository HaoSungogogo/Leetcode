class NumMatrix {
    private int[][] processed;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            processed = matrix;
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int j = 0; j < col; j++) {
            for (int i = 1; i < row; i++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        processed = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int row = processed.length;
        int col = processed[0].length;
        if (row1 < 0 || row1 >= row || row2 < 0 || row2 >= row || col1 < 0 || col1 >= col || col2 < 0 || col2 >= col) {
            return 0;
        }
        int sum = processed[row2][col2];
        if (row1 > 0) {
            sum -= processed[row1 - 1][col2];
        }
        if (col1 > 0) {
            sum -= processed[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            sum += processed[row1 - 1][col1 - 1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
