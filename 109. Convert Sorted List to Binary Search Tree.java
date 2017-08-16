/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return sortedListToBST(head, size);
    }
    private TreeNode sortedListToBST(ListNode head, int size) {
        if (size == 0) {
            return null;
        }
        int index = size / 2;
        int count = index;
        ListNode cur = head;
        while (count > 0) {
            cur = cur.next;
            count--;
        }
        TreeNode newNode = new TreeNode(cur.val);
        newNode.left = sortedListToBST(head, index);
        newNode.right = sortedListToBST(cur.next, size - index - 1);
        return newNode;
    }
}
