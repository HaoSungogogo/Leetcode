/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 Similar BFS
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pollFirst();
            list.add(temp.val);
            if (temp.right != null) {
                stack.offerFirst(temp.right);
            }
            if (temp.left != null) {
                stack.offerFirst(temp.left);
            }
        }
        return list;
    }
}
