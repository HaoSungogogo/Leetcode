/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

Using Stack to model the reversed LinkedList

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> one = new LinkedList<>();
        Deque<Integer> two = new LinkedList<>();
        while (l1 != null) {
            one.offerFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            two.offerFirst(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int carry = 0;
        while (!one.isEmpty() || !two.isEmpty()) {
            int temp = carry;
            if (!one.isEmpty()) {
                temp += one.pollFirst();
            }
            if (!two.isEmpty()) {
                temp += two.pollFirst();
            }
            carry = temp / 10;
            ListNode node = new ListNode(temp % 10);
            node.next = head;
            head = node;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;
    }
}
