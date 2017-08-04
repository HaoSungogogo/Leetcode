Duplicate Subset problem

k-nary tree

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, cur, candidates, target, 0, 0);
        return list;
    }
    private void dfs (List<List<Integer>> list, List<Integer> cur, int[] candidates, int target, int level, int sum) {
        if (sum == target) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = level; i < candidates.length; i++) {
        	if(i > level && candidates[i] == candidates[i - 1]) {
        		continue;
        	}
            if (candidates[i] + sum <= target) {
                cur.add(candidates[i]);
                dfs(list, cur, candidates, target, i + 1, sum + candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

2 branches tree.

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, cur, candidates, target, 0, 0);
        return list;
    }
    private void dfs (List<List<Integer>> list, List<Integer> cur, int[] candidates, int target, int level, int sum) {
        if (sum == target) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        if (sum > target) {
            return;
        }
        if (level == candidates.length) {
            return;
        }
        cur.add(candidates[level]);
        dfs(list, cur, candidates, target, level + 1, sum + candidates[level]);
        cur.remove(cur.size() - 1);

        level++;
        while (level < candidates.length && candidates[level] == candidates[level - 1]) {
            level++;
        }
        dfs(list, cur, candidates, target, level, sum);
    }
}
