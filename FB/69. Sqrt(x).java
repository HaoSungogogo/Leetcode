Using binary search to solve.
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

The first thing to pay attention to is that we always get the smaller one, so
left = mid and mid = left + (right - left + 1) / 2;
The second thing is that we are more likely to come across overflow, we should x / mid
