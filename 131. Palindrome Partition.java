DFS, first constrcut isP table and run DFS O(n^2)

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        List<String> cur = new ArrayList<>();
        char[] array = s.toCharArray();
        int len = s.length();
        boolean[][] isP = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (array[i] == array[j]) {
                    isP[i][j] = j - i < 2 || isP[i + 1][j - 1];
                }
            }
        }
        dfs(list, cur, array, isP, 0);
        return list;
    }
    private void dfs (List<List<String>> list, List<String> cur, char[] array, boolean[][] isP, int level) {
        if (level == array.length) {
            list.add(new ArrayList<String>(cur));
            return;
        }
        for (int i = level; i < array.length; i++) {
            if (isP[level][i]) {
                cur.add(new String(array, level, i - level + 1));
                dfs(list, cur, array, isP, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

DP way: strange data structure. unrecommended O(n)

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        char[] array = s.toCharArray();
        int len = s.length();
        boolean[][] isP = new boolean[len][len];
        List<List<String>>[] dp = new List[len];
        for (int j = 0; j < dp.length; j++) {
            dp[j] = new ArrayList<List<String>>();
            for (int i = j; i >= 0; i--) {
                if (array[i] == array[j]) {
                    isP[i][j] = j - i < 2 || isP[i + 1][j - 1];
                }
                if (isP[i][j]) {
                    if (i == 0) {
                    	List<String> cur = new ArrayList<>();
                    	cur.add(new String(array, 0, j + 1));
                        dp[j].add(cur);
                    } else {
                        List<List<String>> temp = dp[i - 1];
                        for (List<String> iter :  temp) {
                        	List<String> newList = new ArrayList<>(iter);
                        	newList.add(new String(array, i, j - i + 1));
                        	dp[j].add(newList);

                        }
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
