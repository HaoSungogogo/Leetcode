class Solution {
    private final List<Character>[] mapping = new List[]{null, null, Arrays.asList('a', 'b', 'c'), Arrays.asList('d', 'e', 'f'),
                                                         Arrays.asList('g', 'h', 'i'), Arrays.asList('j', 'k', 'l'),
                                                         Arrays.asList('m', 'n', 'o'), Arrays.asList('p', 'q', 'r', 's'),
                                                         Arrays.asList('t', 'u', 'v'), Arrays.asList('w', 'x', 'y', 'z')};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        char[] array = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(list, sb, array, 0);
        return list;
    }
    private void dfs(List<String> list, StringBuilder sb, char[] array, int index) {
        if (index == array.length) {
            list.add(sb.toString());
            return;
        }
        List<Character> cur = mapping[array[index] - '0'];
        if (cur == null) {
            return;
        }
        for (char c : cur) {
            sb.append(c);
            dfs(list, sb, array, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
