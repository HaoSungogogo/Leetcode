class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            return list;
        }
        dfs(list, s, 0, 0, "");
        return list;
    }
    private void dfs(List<String> list, String s, int index, int section, String path) {
        if (index == s.length() && section == 4) {
            list.add(path);
            return;
        }
        if (index == s.length() || section == 4) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (index + i < s.length()) {
                String str = s.substring(index, index + i + 1);
                int num = Integer.parseInt(str);
                if (str.startsWith("0") && str.length() > 1) {
                    continue;
                }
                if (num < 256) {
                    if (section != 3) {
                        dfs(list, s, index + i + 1, section + 1, path + str + ".");
                    } else {
                        dfs(list, s, index + i + 1, section + 1, path + str);
                    }
                }
            }
        }
    }
}
