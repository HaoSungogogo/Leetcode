Time complexity is O(n^2)
using binary search

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int len = nums.length;
        Integer[] res = new Integer[len];
        List<Integer> postfix = new ArrayList<>();
        res[len - 1] = 0;
        postfix.add(nums[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            int index = smallestLargestOrEqual(postfix, nums[i]);
            postfix.add(index, nums[i]);
            res[i] = index;
        }
        return Arrays.asList(res);
    }
    private int smallestLargestOrEqual(List<Integer> postfix, int element) {
        int left = 0;
        int right = postfix.size() - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (postfix.get(mid) >= element) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (postfix.get(right) < element) {
        	return right + 1;
        } else if (postfix.get(left) >= element) {
        	return left;
        } else {
        	return right;
        }
    }
}

MergeSort way of thinking:
index store the result of mergesort, but only store the index.

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int len = nums.length;
        int[] count = new int[len];
        int[] index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        mergeSort(count, index, nums, 0, len - 1);
        List<Integer> list = new ArrayList<>();
        for (int i : count) {
            list.add(i);
        }
        return list;
    }
    private void mergeSort(int[] count, int[] index, int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(count, index, nums, left, mid);
        mergeSort(count, index, nums, mid + 1, right);
        merge(count, index, nums, left, mid, right);
    }
    private void merge(int[] count, int[] index, int[] nums, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];
        int li = left;
        int ri = mid + 1;
        int counter = 0;
        int helperindex = 0;
        while (li <= mid && ri <= right) {
            if (nums[index[ri]] < nums[index[li]]) {
                counter++;
                helper[helperindex] = index[ri];
                ri++;
            } else {
                helper[helperindex] = index[li];
                count[index[li]] += counter;
                li++;
            }
            helperindex++;
        }
        while (li <= mid) {
            helper[helperindex++] = index[li];
            count[index[li]] += counter;
            li++;
        }
        while (ri <= right) {
            helper[helperindex++] = index[ri++];
        }
        for (int i = left; i <= right; i++) {
            index[i] = helper[i - left];
        }
    }
}
