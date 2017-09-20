Get the result when the input is n based on when the input is n - 1 iteratively.

class Solution {
    public List<Integer> grayCode(int n) {
       List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int k = size - 1; k >= 0; k--) {
                list.add(list.get(k) | (1 << i));
            }
        }
        return list;
    }
}
