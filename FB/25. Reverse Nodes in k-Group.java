/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode next = cur;
        ListNode newNode = reverse(head, next);
        head.next = reverseKGroup(next, k);
        return newNode;
    }
    private ListNode reverse(ListNode root, ListNode end) {
        ListNode pre = null;
        ListNode cur = root;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

Iterative way:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode traverse = head;
        ListNode curHead = head;
        while (curHead != null) {
            int count = 0;
            while (traverse != null && count < k) {
            	traverse = traverse.next;
                count++;
            }
            if (count < k) {
                break;
            } else {
                ListNode newHead = reverse(curHead, traverse);
                pre.next = newHead;
                pre = curHead;
                curHead = traverse;
            }
        }
        pre.next = curHead;
        return dummy.next;
    }
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode cur = start;
        ListNode pre = null;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
