class Solution {
    public List<String> findStrobogrammatic(int n) {
        return recursion(n, n);
    }
    private List<String> recursion(int n, int m) {
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        List<String> temp = recursion(n - 2, m);
        List<String> list = new ArrayList<>();
        for (String str : temp) {
           if (n != m) {
                list.add("0" + str + "0");
            }
            list.add("1" + str + "1");
            list.add("6" + str + "9");
            list.add("9" + str + "6");
            list.add("8" + str + "8");
        }
        return list;
    }
}
