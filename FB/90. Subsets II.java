class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        dfs(list, cur, 0, nums);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> cur, int index, int[] nums) {
        if (index == nums.length) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(list, cur, index + 1, nums);
        cur.remove(cur.size() - 1);
        while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
            index++;
        }
        dfs(list, cur, index + 1, nums);

    }
}
