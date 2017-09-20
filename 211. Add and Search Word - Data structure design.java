Time Complexity
O(26^m * n)
m is the # of ?
n is the # of non ?



class WordDictionary {
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (search(word)) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children[word.charAt(i) - 'a'];
            if (next == null) {
                next = new TrieNode();
                cur.children[word.charAt(i) - 'a'] = next;
            }
            cur = next;
        }
        cur.isWord = true;
        return;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        return dfs(word, root, 0);
    }
    private boolean dfs(String word, TrieNode root, int index) {
        if (index == word.length()) {
            if (root.isWord) {
                return true;
            }
            return false;
        }
        char c = word.charAt(index);
        if (c == '.') {
            boolean res = false;
            for (TrieNode node : root.children) {
                if (node != null) {
                    res |= dfs(word, node, index + 1);
                }
            }
            return res;
        } else {
            if (root.children[c - 'a'] != null) {
                return dfs(word, root.children[c - 'a'], index + 1);
            } else {
                return false;
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
