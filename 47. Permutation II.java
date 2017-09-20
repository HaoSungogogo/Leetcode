class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        dfs(list, nums, 0);
        return list;
    }
    private void dfs(List<List<Integer>> list, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) {
            	temp.add(i);
            }
            list.add(temp);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                swap(nums, index, i);
                dfs(list, nums, index + 1);
                swap(nums, index, i);
                set.add(nums[i]);
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
