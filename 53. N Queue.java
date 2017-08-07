class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        List<String> cur = new ArrayList<>();
        List<Integer> record = new ArrayList<>();
        dfs(list, cur, 0, n, record);
        return list;
    }
    private void dfs(List<List<String>> list, List<String> cur, int level, int n, List<Integer> record) {
        if (level == n) {
            list.add(new ArrayList<String>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(record, i)) {
                record.add(i);
                cur.add(getString(i, n));
                dfs(list, cur, level + 1, n, record);
                cur.remove(cur.size() - 1);
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
    private String getString(int index, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == index) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
