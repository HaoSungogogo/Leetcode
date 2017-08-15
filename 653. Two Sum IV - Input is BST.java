/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
Time complexity O(nlogn) -> logn is binary search

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    private boolean dfs(TreeNode root, TreeNode cur, int target) {
        if (cur == null) {
            return false;
        }
        return search(root, cur, target - cur.val) || dfs(root, cur.left, target) || dfs(root, cur.right, target);
    }

    private boolean search(TreeNode root, TreeNode cur, int target) {
        if (root == null) {
            return false;
        }
        if (root != cur && target == root.val) {
            return true;
        }
        if (root.val > target) {
            return search(root.left, cur, target);
        } else {
            return search(root.right, cur, target);
        }
    }
}
