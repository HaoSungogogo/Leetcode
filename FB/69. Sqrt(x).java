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
