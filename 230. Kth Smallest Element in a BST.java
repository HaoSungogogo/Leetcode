/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

terminate dfs in advance using the return value, if true, return directly withoud dfs another branch

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[]{k, 0};
        inorder(root, count);
        return count[1];
    }
    private boolean inorder(TreeNode root, int[] count) {
        if (root == null) {
            return false;
        }
        boolean left = inorder(root.left, count);
        if (left) {
            return true;
        }
        if (--count[0] == 0) {
            count[1] = root.val;
            return true;
        }
        return inorder(root.right, count);
    }
}
