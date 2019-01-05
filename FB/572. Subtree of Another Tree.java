/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(s);
        while (!qu.isEmpty()) {
            TreeNode cur = qu.poll();
            if (check(cur, t)) {
                return true;
            }
            if (cur.left != null) {
                qu.offer(cur.left);
            }
            if (cur.right != null) {
                qu.offer(cur.right);
            }
        }
        return false;
    }
    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        } else {
            return check(s.left, t.left) && check(s.right, t.right);
        }
    }
}
