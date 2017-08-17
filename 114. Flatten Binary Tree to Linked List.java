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
    public void flatten(TreeNode root) {
        recursion(root);
        return;
    }
    private TreeNode recursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = recursion(root.left);
        TreeNode right = recursion(root.right);
        root.left = null;
        if (left == null) {
            root.right = right;
            return root;
        }
        root.right = left;
        while (left.right != null) {
            left = left.right;
        }
        left.right = right;
        return root;
    }
}
