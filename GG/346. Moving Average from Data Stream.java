class MovingAverage {
    private Queue<Integer> qu;
    private int sum;
    private int size;
    private int cap;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.sum = 0;
        this.cap = size;
        this.size = 0;
        qu = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            qu.offer(0);
        }
    }

    public double next(int val) {
        sum = sum - qu.poll() + val;
        size = size == cap ? size : size + 1;
        qu.offer(val);
        return (sum + 0.0) / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
