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
    public int findTilt(TreeNode root) {
        int[] sum = new int[]{0};
        findTilt(root, sum);
        return sum[0];
    }
    private int findTilt(TreeNode root, int[] sum) {
        if (root == null) {
            return 0;
        }
        int left = findTilt(root.left, sum);
        int right = findTilt(root.right, sum);
        sum[0] += Math.abs(left - right);
        return left + right + root.val;
    }
}
