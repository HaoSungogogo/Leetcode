using distinct element in candidates to combine the target with unlimited number
It is the same with 99 cents problem.

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        dfs(list, cur, candidates, target, 0);
        return list;
    }
    private void dfs (List<List<Integer>> list, List<Integer> cur, int[] candidates, int target, int level) {
        if (target == 0) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        if (level == candidates.length) {
            return;
        }
        int val = candidates[level];
        for (int i = 0; i <= target / val; i++) {
            int times = i;
            while (times > 0) {
                cur.add(val);
                times--;
            }
            dfs(list, cur, candidates, target - i * val, level + 1);
            times = i;
            while (times > 0) {
                cur.remove(cur.size() - 1);
                times--;
            }
        }
    }
}
