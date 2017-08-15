addNum O(logn)
findMedian O(1)
maxheap stores smaller half
minheap stores larger half
if so, we could get middle value in O(1)

public class MedianFinder {
    private PriorityQueue<Integer> minheap;  // actual store the larger half
    private PriorityQueue<Integer> maxheap;  // actual store the smaller half
    /** initialize your data structure here. */
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(10000, Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if (minheap.size() > maxheap.size()) {
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek() + 0.0) / 2;
        } else {
            return maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
