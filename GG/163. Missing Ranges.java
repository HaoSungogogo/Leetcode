Just traverse and update the lower sides over and over again.

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            list.add(addStr(lower, upper));
            return list;
        }
        for (int i : nums) {
            if (lower < i) {
                list.add(addStr(lower, i - 1));
                lower = i + 1;
            } else if (lower == i) {
                lower++;
            }
            if (i == Integer.MAX_VALUE) {
                    break;
            }
        }
        if (upper > nums[nums.length - 1]) {
            list.add(addStr(lower, upper));
        }
        return list;
    }
    private String addStr(int left, int right) {
        return left == right ? String.valueOf(left) : String.valueOf(left) + "->" + String.valueOf(right);
    }
}
