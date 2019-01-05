The brute force way:
Using minheap, the time complexity is O(k + (n - k)logk);
               the space complexity is O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.offer(nums[i]);
            } else {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}

Using quick select: average is O(n)
                    worst is O(n^2)
                    average the space is O(logn)
                    worst is O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }
    private int findKthLargest(int[] nums, int k, int left, int right) {
        int index = partition(nums, left, right);
        if (index == k - 1) {
            return nums[index];
        } else if (index < k - 1) {
            return findKthLargest(nums, k, index + 1, right);
        } else {
            return findKthLargest(nums, k, left, index - 1);
        }
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (nums[start] > pivot) {
                start++;
            } else if (nums[end] < pivot) {
                end--;
            } else {
                swap(nums, start++, end--);
            }
        }
        swap(nums, start, right);
        return start;
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

Using binary search, left = min, right = max

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for (int i : nums) {
                if (i >= mid) {
                    count++;
                }
            }
            if (count < k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }
}
