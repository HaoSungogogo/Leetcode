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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] len = new int[]{0};
        if (root == null) {
            return 0;
        }
        diameterOfBinaryTree(root, len);
        return len[0] - 1;
    }
    private int diameterOfBinaryTree(TreeNode root, int[] len) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left, len);
        int right = diameterOfBinaryTree(root.right, len);
        len[0] = Math.max(len[0], left + right + 1);
        return Math.max(left, right) + 1;
    }
}
