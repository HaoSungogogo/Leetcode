/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] len = new int[]{1};
        dfs(root.left, len, root.val, 1);
        dfs(root.right, len, root.val, 1);
        return len[0];
    }
    private void dfs(TreeNode root, int[] len, int pre, int prelen) {
        if (root == null) {
            return;
        }
        if (root.val - pre == 1) {
            prelen++;
            len[0] = Math.max(prelen, len[0]);
        } else {
            prelen = 1;
        }
        dfs(root.left, len, root.val, prelen);
        dfs(root.right, len, root.val, prelen);
    }
}
