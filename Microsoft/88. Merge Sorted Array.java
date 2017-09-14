class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int one = m - 1;
        int two = n - 1;
        while (one >= 0 && two >= 0) {
            if (nums1[one] > nums2[two]) {
                nums1[one + two + 1] = nums1[one];
                one--;
            } else {
                nums1[one + two + 1] = nums2[two];
                two--;
            }
        }
        while (two >= 0) {
            nums1[two] = nums2[two];
            two--;
        }
    }
}
