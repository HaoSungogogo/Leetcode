public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(list, cur, 1, k, n);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> cur, int index, int k, int target) {
        if (cur.size() == k && target == 0) {
            list.add(new ArrayList(cur));
            return;
        }
        if (cur.size() == k) {
            return;
        }
        for(int i = index; i <= 9; i++) {
            cur.add(i);
            dfs(list, cur, i + 1, k, target - i);
            cur.remove(cur.size() - 1);
        }
    }
}