class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * (i + 1);
        }
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n - 2; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(num.get(index));
            num.remove(index);
            k -= index * (factorial[i]);
        }
        sb.append(num.get(0));
        return sb.toString();
    }
}
