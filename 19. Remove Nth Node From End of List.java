/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {
            return slow.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return head;
    }
}
