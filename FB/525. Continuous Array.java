Similar to 523, like prefix sum to be stored in hashmap.

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }
            Integer cur = map.get(sum);
            if (cur != null) {
                max = Math.max(max, i - cur);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
