class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> stack  = new LinkedList<>();
        int prevTime = 0;
        for (String s : logs) {
            String[] str = s.split(":");
            if (stack.isEmpty()) {
                stack.offerFirst(Integer.parseInt(str[0]));
                prevTime = Integer.parseInt(str[2]);
            } else {
                if (str[1].equals("start")) {
                    res[stack.peek()] += Integer.parseInt(str[2]) - prevTime;
                    prevTime = Integer.parseInt(str[2]);
                    stack.offerFirst(Integer.parseInt(str[0]));
                } else {
                    res[stack.peek()] += Integer.parseInt(str[2]) - prevTime + 1;
                    prevTime = Integer.parseInt(str[2]) + 1;
                    stack.pollFirst();
                }
            }
        }
        return res;
    }
}

The time from last funtion to the current function is the exlusion time for the last function.
