class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(list, cur, n, k, 1);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> cur, int n, int k, int num) {
        if (cur.size() == k) {
            list.add(new ArrayList<Integer>(cur));
            return;
        }
        if (num > n) {
            return;
        }
        dfs(list, cur, n, k, num + 1);
        cur.add(num);
        dfs(list, cur, n, k, num + 1);
        cur.remove(cur.size() - 1);
    }
}
