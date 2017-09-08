Using BFS to upstairs level by level and the reason why I use set is that it is easy to find and remove.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) {
            return 0;
        }
        Set<String> set = getSet(wordList);
        Queue<String> qu = new LinkedList<>();
        qu.offer(beginWord);
        int level = 1;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                String cur = qu.poll();
                if (cur.equals(endWord)) {
                    return level;
                }
                for (String str : getNeighbors(set, cur)) {
                    qu.offer(str);
                }
            }
            level++;
        }
        return 0;
    }
    private Set<String> getSet(List<String> list) {
        Set<String> set = new HashSet<>();
        for (String s : list) {
            set.add(s);
        }
        return set;
    }
    private List<String> getNeighbors(Set<String> set, String cur) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            char[] array = cur.toCharArray();
            for(char c = 'a'; c <= 'z'; c++) {
                if (array[i] != c) {
                    array[i] = c;
                    String newString = new String(array);
                    if (set.remove(newString)) {
                        list.add(newString);
                    }
                }
            }
        }
        return list;
    }
}
