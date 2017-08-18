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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        TreeNode cur = root.left;
        while (!stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pollFirst();
                list.add(temp.val);
                cur = temp.right;
                if (cur != null) {
                    stack.offerFirst(cur);
                    cur = cur.left;
                }
            }
        }
        return list;
    }
}
