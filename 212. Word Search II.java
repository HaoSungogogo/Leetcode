Time Complexity: O(kl + mn * 4^l)

class Solution {
    // private final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return list;
        }
        TrieNode root = buildTrie(words);
        StringBuilder sb = new StringBuilder();
        final int row = board.length;
        final int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, root, i, j, sb, list);
            }
        }
        return list;
    }
    private void dfs(char[][] board, TrieNode root, int i, int j, StringBuilder sb, List<String> list) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        sb.append(c);
        if (root.isWord) {
            list.add(sb.toString());
            root.isWord = false;
        }
        board[i][j] = '#';

        if (i > 0) dfs(board, root, i - 1, j, sb, list);
        if (j > 0) dfs(board, root, i, j - 1, sb, list);
        if (i < board.length - 1)  dfs(board, root, i + 1, j, sb, list);
        if (j < board[0].length - 1) dfs(board, root, i, j + 1, sb, list);

        // for (int[] d : dir) {
        //     int x = d[0] + i;
        //     int y = d[1] + j;
        //     dfs(board, root, x, y, sb, list);
        // }
        board[i][j] = c;
        sb.deleteCharAt(sb.length() - 1);
    }
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String str : words) {
            TrieNode cur = root;
            for (int i = 0; i < str.length(); i++) {
                TrieNode next = cur.children[str.charAt(i) - 'a'];
                if (next == null) {
                    next = new TrieNode();
                    cur.children[str.charAt(i) - 'a'] = next;
                }
                cur = next;
            }
            cur.isWord = true;
        }
        return root;
    }
}
