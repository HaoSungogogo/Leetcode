/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

A path from root to leaf base case at the (root.left == 0 && root.right == 0)

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] num = new int[]{0};
        dfs(root, num, 0);
        return num[0];
    }
    private void dfs(TreeNode root, int[] num, int sum) {
        if (root.left == null && root.right == null) {
            num[0] += (sum * 10 + root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, num, sum * 10 + root.val);
        }
        if (root.right != null) {
            dfs(root.right, num, sum * 10 + root.val);
        }
    }
}
