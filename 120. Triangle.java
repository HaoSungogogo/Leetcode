DP way: dp[j] (at i level) -> represents the min path from the root to the j-th element at level i

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int size = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[size];
        for (List<Integer> list : triangle) {
            int[] temp = new int[size];
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    temp[i] = list.get(i) + dp[i];
                } else if (i == list.size() - 1) {
                    temp[i] = list.get(i) + dp[i - 1];
                } else {
                    temp[i] = Math.min(dp[i], dp[i - 1]) + list.get(i);
                }
            }
            dp = temp;
        }
        int min = Integer.MAX_VALUE;
        for (int iter : dp) {
            min = Math.min(min, iter);
        }
        return min;
    }
}
