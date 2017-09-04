When this question involves in character, we could use array to record, not using map. Since array is more easy to be operated than map

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        int[] smap = new int[256];
        int[] tmap = new int[256];
        char[] array = s.toCharArray();
        char[] tarray = t.toCharArray();
        for (char c : tarray) {
            tmap[c]++;
        }
        int slow = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (tmap[array[fast]] > 0) {
                smap[array[fast]]++;
                if (smap[array[fast]] <= tmap[array[fast]]) {
                    count++;
                }
            }

            while (count == tarray.length) {
                if (min > fast - slow + 1) {
                    min = fast - slow + 1;
                    start = slow;
                }
                if (tmap[array[slow]] > 0) {
                	smap[array[slow]]--;
                }
                if (smap[array[slow]] < tmap[array[slow]]) {
                    count--;
                }
                slow++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return new String();
        } else {
            return new String(array, start, min);
        }
    }
}
