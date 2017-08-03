Longest consecutive 1 thinking.
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] longest = new int[row][col];
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0) {
                    longest[i][j] = matrix[i][j] - '0';
                    continue;
                }
                if (matrix[i][j] == '1') {
                    longest[i][j] = longest[i - 1][j] + 1;
                }
            }
        }
        for(int j = 0; j < row; j++) {
            for (int i = 0; i <= j; i++) {
                int curmax = 0;
                int start = 0;
                for(int k = 0; k < col; k++) {
                    if(longest[j][k] - longest[i][k] == j - i && longest[i][k] != 0) {
                        start++;
                        curmax = Math.max(start, curmax);
                    } else {
                        start = 0;
                    }
                }
                max = Math.max(max, curmax * (j - i + 1));
            }
        }
        return max;
    }
}

单调栈： similar to the largest rectangular way.
        run longest consecutive 1 in each row.
        run largest rectangular in each row

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] h = new int[col + 1];
        for (int i = 0; i < row; i++) {
            Deque<Integer> stack = new LinkedList<>();
            for (int j = 0; j < col + 1; j++) {
                if (j < col) {
                    if (matrix[i][j] == '1') {
                        h[j]++;
                    }
                }
                while (!stack.isEmpty() && h[stack.peekFirst()] >= h[j]) {
                    int height = h[stack.pollFirst()];
                    int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                    max = Math.max(max, height * (j - left));
                }
                stack.offerFirst(j);
            }
        }
        return max;
    }
}