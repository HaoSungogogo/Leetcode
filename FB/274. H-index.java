Naive way, sort first.
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int num = 0;
        int pre = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (num > citations[i]) {
                return Math.min(pre, num);
            }
            num++;
            pre = citations[i];
        }
        return Math.min(citations[0], num);
    }
}

O(n)

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int[] res = new int[len + 1];
        for (int i : citations) {
            if (i >= len) {
                res[len]++;
            } else {
                res[i]++;
            }
        }
        int count = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            count += res[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
