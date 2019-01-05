class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level < stack.size()) {
                stack.pollFirst();
            }
            int len = 0;
            if (stack.isEmpty()) {
                len = s.length();
            } else {
                len = stack.peekFirst() + s.length() - level + 1;
            }
            stack.offerFirst(len);
            if (s.contains(".")) {
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
