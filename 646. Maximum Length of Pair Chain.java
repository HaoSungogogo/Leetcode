Sorting first and using the acending subarray way.

class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 ||  pairs[0].length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]> () {
        	public int compare(int[] o1, int[] o2) {
        		if (o1[0] < o2[0]) {
        			return -1;
        		} else if (o1[0] > o2[0]) {
        			return 1;
        		} else if (o1[1] < o2[1]) {
        			return -1;
        		} else if (o1[1] > o2[1]) {
        			return 1;
        		} else {
        			return 0;
        		}
        	}
        });
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
