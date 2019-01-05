Time Complexity: O(n^2)
Spcae Complexity: worse case O(n^2)

class Solution {
    static class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    public void addNode(TrieNode root, String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TrieNode next = cur.children[c - 'a'];
            if (next == null) {
                next = new TrieNode();
                cur.children[c - 'a'] = next;
            }
            cur = next;
        }
        cur.word = s;
    }
    public TrieNode buildTrie(String[] str) {
        TrieNode root = new TrieNode();
        for (String s : str) {
            addNode(root, s);
        }
        return root;
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        TrieNode root = buildTrie(words);
        int len = words[0].length();
        TrieNode[] rows = new TrieNode[len];
        for (int i = 0; i < len; i++) {
            rows[i] = root;
        }
        dfs(0, 0, len, rows, res);
        return res;
    }
    private void dfs(int row, int col, int len, TrieNode[] rows, List<List<String>> res) {
        if (col == row && row == len) {
            List<String> cur = new ArrayList<>();
            for (TrieNode node : rows) {
                cur.add(node.word);
            }
            res.add(cur);
            return;
        }

        if (col < len) {
            TrieNode preRow = rows[row];
            TrieNode preCol = rows[col];
            for (int i = 0; i < 26; i++) {
                if (rows[row].children[i] != null && rows[col].children[i] != null) {
                    rows[row] = rows[row].children[i];
                    if (row != col) {
                        rows[col] = rows[col].children[i];
                    }
                    dfs(row, col + 1, len, rows, res);
                    rows[row] = preRow;
                    if (row != col) {
                        rows[col] = preCol;
                    }

                }
            }
        } else {
            dfs(row + 1, row + 1, len, rows, res);
        }
    }
}
