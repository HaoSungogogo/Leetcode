class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int city = flights.length;
        int weeks = days[0].length;
        int[] dp = new int[city];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < weeks; i++) {
            int[] temp = new int[city];
            Arrays.fill(temp, -1);
            for (int j = 0; j < city; j++) {
                for (int k = 0; k < city; k++) {
                    if (dp[k] != -1) {
                        if (j == k || flights[k][j] == 1) {
                            temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                        }
                    }
                }
            }
            dp = temp;
        }
        int res = -1;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
