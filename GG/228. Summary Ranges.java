class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int i = 0;
        while (i < nums.length) {
            int cur = i;
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (i == cur) {
                list.add(String.valueOf(nums[i]));
            } else {
                list.add(nums[cur] + "->" + nums[i]);
            }
            i++;
        }
        return list;
    }
}
