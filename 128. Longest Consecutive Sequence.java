value record the current length of sequence and only update the boundary whih is enough

class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer temp = map.get(i);
            if (temp != null) {
                continue;
            }
            int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
            int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;
            int sum = left + right + 1;
            map.put(i, sum);
            max = Math.max(max, sum);
            map.put(i - left, sum);
            map.put(i + right, sum);
        }
        return max;
    }
}
