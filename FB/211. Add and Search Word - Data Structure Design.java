Add -> O(n)
Search worst case is O(mn)
n is the average length of string and m is the number of string stored in the dictionary


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
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode next = cur.children[c - 'a'];
            if (next == null) {
                next = new TrieNode();
                cur.children[c - 'a'] = next;
            }
            cur = next;
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, root, 0);
    }
    private boolean dfs(String word, TrieNode root, int index) {
        if (index == word.length()) {
            return root.isWord;
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
            TrieNode next = root.children[c - 'a'];
            if (next == null) {
                return false;
            } else {
                return dfs(word, next, index + 1);
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
