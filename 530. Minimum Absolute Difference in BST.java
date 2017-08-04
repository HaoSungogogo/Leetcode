/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Using the special bondary in bst according to the parent node
// the boundary is shrinking again and again, the it is 最值

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        int[] min = new int[]{Integer.MAX_VALUE};
        recursion(root, min, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return min[0];
    }
    private void recursion(TreeNode root, int[] min, int left, int right) {
        if (root == null) {
            return;
        }
        if (left != Integer.MIN_VALUE) {
            min[0] = Math.min(min[0], root.val - left);
        }
        if (right != Integer.MAX_VALUE) {
            min[0] = Math.min(min[0], right - root.val);
        }
        recursion(root.left, min, left, root.val);
        recursion(root.right, min, root.val, right);
    }
}

// inorder way and record the prev node. the minimum value must exist between adjacent element
public class Solution {
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        int[] min = new int[]{Integer.MAX_VALUE};
        inorder(root, min);
        return min[0];
    }
    private void inorder(TreeNode root, int[] min) {
        if (root == null) {
            return;
        }
        inorder(root.left, min);
        if (prev != null) {
            min[0] = Math.min(min[0], root.val - prev.val);
        }
        prev = root;
        inorder(root.right, min);
    }
}
