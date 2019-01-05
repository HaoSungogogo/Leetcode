public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len).append('-').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int cur = 0;
        while (cur < s.length()) {
            int dash = s.indexOf("-", cur);
            int size = Integer.valueOf(s.substring(cur, dash));
            list.add(s.substring(dash + 1, dash + size + 1));
            cur = dash + size + 1;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));


Using this pattern: size + "-" + String
