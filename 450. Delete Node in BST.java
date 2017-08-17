/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
we will have following situations
1. delete node is leafnode
2. delete node only hava left or right child
3. delete node have right child which does not have left child
4. delete node have right child which has left child

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        TreeNode pre = root.right;
        TreeNode cur = root.right.left;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        pre.left = cur.right;
        cur.left = root.left;
        cur.right = root.right;
        return cur;
    }
}
