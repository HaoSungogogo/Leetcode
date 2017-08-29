class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        int res = 1;
        int idx = 0;
        Pair[] dp = new Pair[nums.length];
        dp[0] = new Pair(1, -1);
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            int index = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if(dp[j].len > max) {
                        max = dp[j].len;
                        index = j;
                    }
                }
            }
            dp[i] = new Pair(max + 1, index);
            if (max + 1 > res) {
                res = max + 1;
                idx = i;
            }
        }
        while (res > 0) {
            list.add(0, nums[idx]);
            res--;
            idx = dp[idx].preIndex;
        }
        return list;
    }
    class Pair{
        int len;
        int preIndex;
        public Pair(int len, int preIndex) {
            this.len = len;
            this.preIndex = preIndex;
        }
    }
}
