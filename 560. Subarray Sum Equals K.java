For the subarraysum, it first comes to me prefix sum.
and use map to record it. when traverse, we only need to check prefix - target.

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prefix = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            Integer temp = map.get(prefix - k);
            if (temp != null) {
                res += temp;
            }
            Integer cur = map.get(prefix);
            if (cur == null) {
                map.put(prefix, 1);
            } else {
                map.put(prefix, cur + 1);
            }
        }
        return res;
    }
}
