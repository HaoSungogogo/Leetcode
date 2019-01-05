class ValidWordAbbr {
    private Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String key = getKey(s);
            String cur = map.get(key);
            if (cur == null) {
                map.put(key, s);
            } else {
                if (!cur.equals(s)) {
                    map.put(key, "");
                }
            }
        }
    }

    private String getKey(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }

    public boolean isUnique(String word) {
        String cur = map.get(getKey(word));
        if (cur == null) {
            return true;
        }
        return cur.equals(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
