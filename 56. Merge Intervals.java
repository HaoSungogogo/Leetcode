/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
Sorting first

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start > o2.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Iterator<Interval> iter = intervals.iterator();
        Interval cur = iter.next();
        while (iter.hasNext()) {
            Interval next = iter.next();
            if (cur.end < next.start) {
                cur = next;
            } else {
                cur.end = Math.max(next.end, cur.end);
                iter.remove();
            }
        }
        return intervals;
    }
}
