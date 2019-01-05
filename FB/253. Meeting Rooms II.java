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
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval o1, Interval o2) {
               if (o1.start == o2.start) {
                   return 0;
               }
               return o1.start < o2.start ? -1 : 1;
           }
    });
        PriorityQueue<Interval> pq = new PriorityQueue<>(11, new Comparator<Interval> () {
           public int compare(Interval o1, Interval o2) {
               if (o1.end == o2.end) {
                   return 0;
               }
               return o1.end < o2.end ? -1 : 1;
           }
        });
        for (Interval i : intervals) {
            if (!pq.isEmpty() && pq.peek().end <= i.start) {
                pq.poll();
            }
            pq.offer(i);
        }
        return pq.size();
    }
}

Make the better use of gap time.
