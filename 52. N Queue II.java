class Solution {
    public int totalNQueens(int n) {
        int[] res = new int[]{0};
        List<Integer> record = new ArrayList<>();
        if (n <= 0) {
            return 0;
        }
        dfs(record, res, 0, n);
        return res[0];
    }
    private void dfs(List<Integer> record, int[] res, int level, int n) {
        if (level == n) {
            res[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(record, i)) {
                record.add(i);
                dfs(record, res, level + 1, n);
                record.remove(record.size() - 1);
            }
        }
    }
    private boolean check (List<Integer> record, int index) {
        for (int i = 0 ; i < record.size(); i++) {
            if (index == record.get(i) || record.size() - i == Math.abs(record.get(i) - index)) {
                return false;
            }
        }
        return true;
    }
}
