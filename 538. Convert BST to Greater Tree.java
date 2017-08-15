/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Using BST property and in-order traversal.

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[]{0};
        convertBST(root, sum);
        return root;
    }
    private void convertBST(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        convertBST(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;
        convertBST(root.left, sum);
    }
}
