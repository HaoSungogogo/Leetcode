class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int cur = 0;
        while (cur < words.length) {
            int len = words[cur].length();
            int next = cur + 1;
            // Try to put the string as much as possible
            while (next < words.length && len + words[next].length() + 1 <= maxWidth) {
                len += words[next].length() + 1;
                next++;
            }
            StringBuilder sb = new StringBuilder();
            // if it is the last line or only permit one letter to put in -> left justified
            if (next == words.length || next - cur == 1) {
                for (int i = cur; i < next; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int k = sb.length(); k < maxWidth; k++) {
                    sb.append(' ');
                }
            } else {
              // left justified and right justified
                int spaceSum = maxWidth - len;
                int count = next - cur;
                int spaceEach = spaceSum / (count - 1);
                int spaceRedt = spaceSum % (count - 1);
                for (int i = 0; i < count; i ++) {
                    if (i < count - 1) {
                        sb.append(words[cur + i]);
                        sb.append(" ");
                        for (int k = 0; k < spaceEach; k++) {
                            sb.append(" ");
                        }
                        if (i < spaceRedt) {
                            sb.append(" ");
                        }
                    } else {
                        sb.append(words[cur + count - 1]);
                    }
                }
            }
            list.add(sb.toString());
            cur = next;
        }
        return list;
    }
}
