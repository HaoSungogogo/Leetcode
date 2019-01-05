/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 Time complexity: O(n)
 Space complexity: O(logn) if it is balanced
 Better than using map.


class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> minStack = new LinkedList<>();
        Deque<TreeNode> maxStack = new LinkedList<>();
        addNode(minStack, root, true);
        addNode(maxStack, root, false);
        while (minStack.peek() != maxStack.peek()) {
            int value = minStack.peek().val + maxStack.peek().val;
            if (value == k) {
                return true;
            } else if (value > k) {
               addNext(maxStack, false);
            } else {
                addNext(minStack, true);
            }
        }
        return false;
    }
    private void addNode(Deque<TreeNode> stack, TreeNode root, boolean isLeft) {
        while (root != null) {
            stack.offerFirst(root);
            if (isLeft) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
    private void addNext(Deque<TreeNode> stack, boolean isLeft) {
        TreeNode cur = stack.pollFirst();
        if (isLeft) {
            addNode(stack, cur.right, true);
        } else {
            addNode(stack, cur.left, false);
        }
    }
}
