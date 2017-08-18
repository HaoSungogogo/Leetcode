/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Only maintain the global variable, only dereference can retain value in the recursion.

public class Solution {
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    TreeNode one = null;
    TreeNode two = null;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root);
        int temp = one.val;
        one.val = two.val;
        two.val = temp;

    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (root.val <= pre.val && one == null) {
            one = pre;
        }
        if (root.val <= pre.val && one != null) {
            two = root;

        }
        pre = root;
        inorder(root.right);
    }
}
