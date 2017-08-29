class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0 || B == null || B.length == 0 || C == null || C.length == 0) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                int sum = i + j;
                Integer temp = map.get(sum);
                if(temp == null) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, temp + 1);
                }
            }
        }
        for (int i : C) {
            for (int j : D) {
                int sum = -i - j;
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;
    }
}
