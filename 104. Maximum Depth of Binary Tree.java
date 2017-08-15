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
    public int maxDepth(TreeNode root) {
        int[] max = new int[]{0};
        dfs(root, 0, max);
        return max[0];
    }
    private void dfs(TreeNode root, int level, int[] max) {
        if (root == null) {
            max[0] = Math.max(max[0], level);
            return;
        }
        dfs(root.left, level + 1, max);
        dfs(root.right, level + 1, max);
    }
}
104. Maximum Depth of Binary Tree
