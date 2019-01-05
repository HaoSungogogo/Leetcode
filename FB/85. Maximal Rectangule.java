O(n^2 + n^3) + O(n^2)
O(n^2)

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : dp[i - 1][j] + 1;
                }
            }
        }
        for (int j = 0; j < row; j++) {
            for (int i = 0; i <= j; i++) {
                int len = 0;
                int curmax = 0;
                for (int k = 0; k < col; k++) {
                    if (dp[j][k] >= j - i + 1) {
                        len++;
                        curmax = Math.max(curmax, len);
                    } else {
                        len = 0;
                    }
                }
                max = Math.max(max, curmax * (j - i + 1));
            }
        }
        return max;
    }
}

Fancy way: using the same idea of Largest Rectangle in Histogram
O(n^2)
O(n) space

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[] h = new int[col + 1];
        h[col] = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col + 1; j++) {
                if (j < col) {
                    if (matrix[i][j] == '0') {
                        h[j] = 0;
                    } else {
                        h[j]++;
                    }
                }
                while (!stack.isEmpty() && h[stack.peekFirst()] >= h[j]) {
                    int index = stack.pollFirst();
                    max = Math.max(max, h[index] * (stack.isEmpty() ? j : j - stack.peekFirst() - 1));
                }
                stack.offerFirst(j);
            }
        }
        return max;
    }
}
