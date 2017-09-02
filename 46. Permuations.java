class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        dfs(list, cur, nums, 0);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> cur, int[] nums, int level) {
        if (level == nums.length) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            cur.add(nums[level]);
            dfs(list, cur, nums, level + 1);
            swap(nums, level, i);
            cur.remove(cur.size() - 1);
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
