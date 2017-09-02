For every String, sort it first, use it as a key

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String temp = new String(array);
            List<String> cur = map.get(temp);
            if (cur == null) {
                cur = new ArrayList<String>();
                map.put(temp, cur);
            }
            cur.add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
