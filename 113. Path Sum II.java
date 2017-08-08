/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        dfs(list, cur, root, sum);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> cur, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            cur.add(root.val);
            list.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        cur.add(root.val);
        dfs(list, cur, root.left, sum - root.val);
        dfs(list, cur, root.right, sum - root.val);
        cur.remove(cur.size() - 1);
    }
}
