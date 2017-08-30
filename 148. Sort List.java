/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

Using Merge Sort to sort this list.

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = fast;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(pre));
    }
    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.val < two.val) {
                cur.next = one;
                cur = cur.next;
                one = one.next;
            } else {
                cur.next = two;
                cur = cur.next;
                two = two.next;
            }
        }
        if(one != null) {
            cur.next = one;
        }
        if (two != null) {
            cur.next = two;
        }
        return dummy.next;
    }
}
