/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Search all the possible path, so we have to start from every node. Time Complexity is O(n^2)

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
       return fixedStartPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int fixedStartPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (sum == root.val) {
            count++;
        }
        int left = fixedStartPath(root.left, sum - root.val);
        int right = fixedStartPath(root.right, sum - root.val);
        return left + right + count;
    }
}
