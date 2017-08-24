class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = getSet(wordDict);
        int size = s.length();
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for (int i = 1; i < size + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[size];
    }
    private Set<String> getSet(List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        return set;
    }
}
