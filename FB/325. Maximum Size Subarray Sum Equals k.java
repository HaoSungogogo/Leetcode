class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            Integer index = map.get(prefixSum - k);
            if (index != null) {
                max = Math.max(max, i - index);
            }
            Integer temp = map.get(prefixSum);
            if (temp == null) {
                map.put(prefixSum, i);
            }
        }
        return max;
    }
}
