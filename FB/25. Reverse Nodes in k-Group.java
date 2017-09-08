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
        int time = k;
        ListNode cur = head;
        while (time > 0) {
            if (cur == null) {
                break;
            }
            time--;
            cur = cur.next;
        }
        if (time != 0) {
            return head;
        }
        ListNode newNode = reverseKGroup(cur, k);
        ListNode newReverseNode = reverse(head, k);
        head.next = newNode;
        return newReverseNode;
    }
    private ListNode reverse(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode newNode = reverse(head.next, k - 1);
        head.next.next = head;
        head.next = null;
        return newNode;
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
        while (traverse != null) {
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
