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
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = qu.poll();
                if (i == 0) {
                    res = cur.val;
                }
                if (cur.left != null) {
                    qu.offer(cur.left);
                }
                if (cur.right != null) {
                    qu.offer(cur.right);
                }
            }
        }
        return res;
    }
}
