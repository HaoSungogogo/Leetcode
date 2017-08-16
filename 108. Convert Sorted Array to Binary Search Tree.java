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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = start + (end - start + 1) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = sortedArrayToBST(nums, start, index - 1);
        root.right = sortedArrayToBST(nums, index + 1, end);
        return root;
    }
}

108. Convert Sorted Array to Binary Search Tree
