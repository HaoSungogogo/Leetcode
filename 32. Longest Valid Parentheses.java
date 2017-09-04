Using stack to record the index.
max = Math.max(max, i - stack.peekFirst());

Record the last element that is mismatched.

class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(-1);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == '(') {
                stack.offerFirst(i);
            } else {
                stack.pollFirst();
                if (stack.isEmpty()) {
                    stack.offerFirst(i);
                } else {
                    max = Math.max(max, i - stack.peekFirst());
                }
            }
        }
        return max;
    }
}
