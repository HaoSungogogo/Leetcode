Maintain two stack, the one store the times, the other store the preString

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        Deque<Integer> coefficient = new LinkedList<>();
        Deque<String> preStr = new LinkedList<>();
        String cur = new String();
        int i = 0;
        while (i < array.length) {
            if (array[i] >= '0' && array[i] <= '9') {
                int num = 0;
                while (i < array.length && array[i] >= '0' && array[i] <= '9') {
                    num = num * 10 + array[i] - '0';
                    i++;
                }
                coefficient.offerFirst(num);
            } else if (array[i] == '[') {
                preStr.offerFirst(cur);
                cur = new String();
                i++;
            } else if (array[i] == ']') {
                int times = coefficient.pollFirst();
                StringBuilder sb = new StringBuilder(preStr.pollFirst());
                while (times > 0) {
                    sb.append(cur);
                    times--;
                }
                cur = sb.toString();
                i++;
            } else {
                cur += array[i];
                i++;
            }
        }
        return cur;
    }
}
