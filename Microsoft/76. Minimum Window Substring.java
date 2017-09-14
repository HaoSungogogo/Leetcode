Much better way.

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        int[] tmap = new int[256];
        char[] array = s.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            tmap[t.charAt(i)]++;
        }
        int slow = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int fast = 0;
        int count = t.length();
        while (fast < array.length) {
            if(tmap[array[fast++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (min > fast - slow) {
                    min = fast - slow;
                    start = slow;
                }
                if (tmap[array[slow++]]++ == 0) {
                    count++;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return new String();
        } else {
            return new String(array, start, min);
        }
    }
}
