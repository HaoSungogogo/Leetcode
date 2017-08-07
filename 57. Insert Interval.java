/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

Sort the start and end respectively

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null) {
            return intervals;
        }
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        int size = intervals.size();
        int[] starts = new int[size + 1];
        int[] ends = new int[size + 1];
        starts[size] = newInterval.start;
        ends[size] = newInterval.end;
        for (int i = 0; i < size; i++) {
            Interval cur = intervals.get(i);
            starts[i] = cur.start;
            ends[i] = cur.end;
        }
        Arrays.sort(starts);
	      Arrays.sort(ends);
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < size + 1; i++) { // j is start of interval.
            if (i == size || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null) {
            return intervals;
        }
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        boolean flag = false;
        for (Interval iter : intervals) {
            if (flag || iter.end < newInterval.start) {
                res.add(iter);
            } else if (newInterval.end < iter.start) {
                res.add(newInterval);
                res.add(iter);
                flag = true;
            } else {
                newInterval.start = Math.min(iter.start, newInterval.start);
                newInterval.end = Math.max(iter.end, newInterval.end);
            }
        }
        if (!flag) {
            res.add(newInterval);
        }
       return res;
    }
}
