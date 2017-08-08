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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }
    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }
        max[0] = Math.max(max[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
