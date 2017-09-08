/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

Level-Order traversal

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        while (root != null) {
            TreeLinkNode cur = root;
            while(cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        head = cur.left;
                        pre = head;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    if (head == null) {
                        head = cur.right;
                        pre = head;
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            root = head;
            head = null;
            pre = null;
        }
    }
}
