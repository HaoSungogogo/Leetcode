class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return list;
        }
        char[] array = num.toCharArray();
        dfs(list, array, target, 0, 0, 0, "");
        return list;
    }
    private void dfs(List<String> list, char[] array, int target, int index, long sum, long pre, String path) {
        if (index == array.length) {
            if (sum == target) {
                list.add(path);
            }
            return;
        }
        long num = 0;
        for (int i = index; i < array.length; i++) {
            if (i != index && array[index] == '0') {
                break;
            }
            num = num * 10 + array[i] - '0';
            if (index == 0) {
                dfs(list, array, target, i + 1, num, num, path + num);
            } else {
                dfs(list, array, target, i + 1, sum + num, num, path + '+' + num);
                dfs(list, array, target, i + 1, sum - num, -num, path + '-' + num);
                dfs(list, array, target, i + 1, sum - pre + pre * num, pre * num, path + '*' + num);
            }
        }
    }
}
