

class Solution {
    private String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> qu = new LinkedList<>();
        if (digits.length() == 0) {
            return qu;
        }
        qu.offer("");
        for (int i = 0; i < digits.length(); i++) {
            int size = qu.size();
            for (int j = 0; j < size; j++) {
                String temp = qu.poll();
                for (char c : mapping[digits.charAt(i) - '0'].toCharArray()) {
                    qu.offer(temp + c);
                }
            }
        }
        return qu;
    }
}
Using the bfs, the time complexity is still O(4^n)
