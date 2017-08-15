Lazy Deletion
O(nlogk)
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                pq.offer(new Pair(nums[i], i));
            } else {
                pq.offer(new Pair(nums[i], i));
                while (pq.peek().index < i - k + 1) {
                    pq.poll();
                }
                res[i - k + 1] = pq.peek().val;
            }
        }
        return res;
    }
    class Pair implements Comparable<Pair> {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
        @Override
        public int compareTo(Pair another) {
            if (this.val == another.val) {
            	return 0;
            }
            return this.val > another.val ? -1 : 1;
        }
    }
}



单调栈
O(n)
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Pair> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peekFirst().val < nums[i]) {
                stack.pollFirst();
            }
            stack.offerFirst(new Pair(nums[i], i));
            if (i >= k - 1) {
                while (stack.peekLast().index < i - k + 1) {
                    stack.pollLast();
                }
                res[i - k + 1] = stack.peekLast().val;
            }
        }
        return res;
    }
    class Pair {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
