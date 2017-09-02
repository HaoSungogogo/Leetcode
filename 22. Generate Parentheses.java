class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        dfs(list, sb, 0, 0, n);
        return list;
    }
    private void dfs(List<String> list, StringBuilder sb, int left, int right, int n) {
        if (left == n && right == n) {
            list.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(list, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            dfs(list, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
