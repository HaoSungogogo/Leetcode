The result must be in the range between max from sum, since it is non-negative.
So we could binary search (max - sum)

class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (m == 1) {
            return sum;
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(mid, nums, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean valid(int mid, int[] nums, int m) {
        int count = 1;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum > mid) {
                count++;
                sum = i;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
