For each two adjacent words in the input, we could get the relationship of two alphebat.
So we could get a set of edges.
We want to get the order of the vertex. So it is a topological sort. -> using dfs to traverse all the vertex
along the edge, if we get the cycle, we get nothing.

class Solution {
    public String alienOrder(String[] words) {
        int[] vertex = new int[26];
        boolean[][] edge = new boolean[26][26];
        buildGraph(vertex, edge, words);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (vertex[i] == 0) {
                if (!dfs(vertex, edge, i, sb)) {
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }
    private void buildGraph(int[] vertex, boolean[][] edge, String[] words) {
        Arrays.fill(vertex, -1);
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                vertex[c - 'a'] = 0;
            }
            if (i > 0) {
                String prev = words[i - 1];
                String cur = words[i];
                int len = Math.min(prev.length(), cur.length());
                for (int j = 0; j < len; j++) {
                    char p = prev.charAt(j);
                    char c = cur.charAt(j);
                    if (p != c) {
                        edge[p - 'a'][c - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
    private boolean dfs(int[] vertex, boolean[][] edge, int i, StringBuilder sb) {
        vertex[i] = 1;
        for (int j = 0; j < 26; j++) {
            if (edge[i][j]) {
                if (vertex[j] == 1) {
                    return false;
                }
                if (vertex[j] == 0) {
                    if (!dfs(vertex, edge, j, sb)) {
                        return false;
                    }
                }
            }
        }
        vertex[i] = 2;
        sb.append((char)(i + 'a'));
        return true;
    }
}
