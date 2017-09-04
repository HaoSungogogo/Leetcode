Using DFS, record the lastRemove index and lastTraverse index
if we come across mismached, we remove one
when remove, we only remove the first one if it is consecutive ')'

And reverse, to deal with '(' is redundanct, reverse the logic.

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        remove(list, s, 0, 0, new char[]{'(', ')'});
        return list;
    }
    private void remove(List<String> list, String s, int lastRemove, int lastTraverse, char[] pair) {
        int stack = 0;
        for (int i = lastTraverse; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) {
                stack++;
            }
            if (s.charAt(i) == pair[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            } else {
                for (int j = lastRemove; j <= i; j++) {
                    if (s.charAt(j) == pair[1] && (j == lastRemove || s.charAt(j) != s.charAt(j - 1))) {
                        remove(list, s.substring(0, j) + s.substring(j + 1, s.length()), j, i, pair);
                    }
                }
            }
            return;
        }
        String rev = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            remove(list, rev, 0, 0, new char[]{')', '('});
        } else {
            list.add(rev);
        }
    }
}
