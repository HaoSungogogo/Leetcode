/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return 0;
                }
                return o1.start - o2.start;
            }
        });
        List<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = list.get(list.size() - 1);
            Interval curr = intervals.get(i);
            if (temp.end >= curr.start) {
                temp.end = Math.max(temp.end, curr.end);
            } else {
                list.add(curr);
            }
        }
        return list;
    }
}
Not inplace remove.
If we want to remove inplace, we must need iterator.
