class HitCounter {
    private Queue<Integer> qu;
    private int count;
    /** Initialize your data structure here. */
    public HitCounter() {
        qu = new LinkedList<>();
        count = 0;
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        count++;
        qu.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!qu.isEmpty() && qu.peek() <= timestamp - 300) {
            qu.poll();
            count--;
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
