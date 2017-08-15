/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(11, new Comparator<ListNode> () {
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val == l2.val) {
                    return 0;
                }
                return l1.val < l2.val ? -1 : 1;
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (ListNode iter : lists) {
            if (iter != null) {
                pq.offer(iter);
            }
        }
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = temp;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
