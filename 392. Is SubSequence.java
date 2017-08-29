O(k + n)
public class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        int count = 0;
        int cur = 0;
        for (char c : sarray) {
            while (cur < tarray.length) {
                if (tarray[cur] == c) {
                    count++;
                    cur++;
                    break;
                }
                cur++;
            }
            if (count != sarray.length && cur >= tarray.length) {
                return false;
            }
        }
        return true;
    }
}

Follow Up: O(klogn)
Using map to record and use prev to record last char index.

Binary search

class Solution {
	    public boolean isSubsequence(String s, String t) {
	        char[] sarray = s.toCharArray();
	        char[] tarray = t.toCharArray();
	        Map<Character, List<Integer>> map = new HashMap<>();
	        for (int i = 0; i < tarray.length; i++) {
	            List<Integer> temp = map.get(tarray[i]);
	            if (temp == null) {
	                temp = new ArrayList<Integer>();
	                map.put(tarray[i], temp);
	            }
	            temp.add(i);
	        }
	        System.out.println(map);

	        int prev = -1;
	        for (int i = 0; i < sarray.length; i++) {
	            List<Integer> list = map.get(sarray[i]);
	            if (list == null) {
	                return false;
	            }
	            int index = smallestLarger(list, 0, list.size() - 1, prev);
	            if (index == -1) {
	                return false;
	            }
	            prev = index;
	        }
	        return true;
	    }
	    private int smallestLarger(List<Integer> list, int left, int right, int prev) {
	        while (left < right - 1) {
	            int mid = left + (right - left) / 2;
	            if (list.get(mid) > prev) {
	                right = mid;
	            } else {
	                left = mid;
	            }
	        }
	        if (list.get(left) > prev) {
	            return list.get(left);
	        }
	        if (list.get(right) > prev) {
	            return list.get(right);
	        }
	        return -1;
	    }
	}
