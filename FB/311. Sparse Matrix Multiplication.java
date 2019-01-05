Brute Force way: it may be time limit exceeded

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int mB = B[0].length;
        int[][] res = new int[n][mB];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mB; j++) {
                for (int k = 0; k < m; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}

if we come across the 0, we skip it in advance

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int mB = B[0].length;
        int[][] res = new int[n][mB];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < mB; j++) {
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return res;
    }
}

Compress the sparse matrix, make the sparse matrix into a list of (col, non zero value) pair

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int mB = B[0].length;
        int[][] res = new int[n][mB];
        List<Integer>[] row = new List[n];
        for (int i = 0; i < n; i++) {
            row[i] = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                if (A[i][j] != 0) {
                    row[i].add(j);
                    row[i].add(A[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            List<Integer> cur = row[i];
            for (int k = 0; k < cur.size() - 1; k += 2) {
                int colNum = cur.get(k);
                int value = cur.get(k + 1);
                for (int j = 0; j < mB; j++) {
                    res[i][j] += value * B[colNum][j];
                }
            }
        }
        return res;
    }
}
