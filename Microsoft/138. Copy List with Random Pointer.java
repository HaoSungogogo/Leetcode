/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        while (head != null) {
            if (head.next != null) {
                RandomListNode cur = map.get(head.next);
                if (cur == null) {
                    cur = new RandomListNode(head.next.label);
                    map.put(head.next, cur);
                }
                map.get(head).next = cur;
            }
            if (head.random != null) {
                RandomListNode cur = map.get(head.random);
                if (cur == null) {
                    cur = new RandomListNode(head.random.label);
                    map.put(head.random, cur);
                }
                map.get(head).random = cur;
            }
            head = head.next;
        }
        return newHead;
    }
}
