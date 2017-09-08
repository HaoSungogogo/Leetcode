class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        }
        int[] count = new int[words.length];
        for (int i = 0; i < count.length; i++) {
            count[i] = words[i].length();
        }
        int start = count[0];
        int num = 1;
        int i = 1;
        while (i <= count.length) {
            while (i < count.length && start + 1 + count[i] <= maxWidth) {
                start += 1 + count[i];
                num++;
                i++;
            }
            if (i == count.length) {
                StringBuilder sb = new StringBuilder();
                for (int j = i - num; j < i - 1; j++) {
                    sb.append(words[j]);
                    sb.append(" ");
                }
                sb.append(words[i - 1]);
                for (int k = maxWidth - sb.length(); k > 0; k--) {
                    sb.append(" ");
                }
                list.add(sb.toString());
                break;
            }
            int diff = maxWidth - start;
            StringBuilder sb = new StringBuilder();
            if (num == 1) {
                sb.append(words[i - 1]);
                while (diff > 0) {
                    sb.append(" ");
                    diff--;
                }
            } else {
                int spaceNum = diff / (num - 1);
                int spaceRedundant = diff % (num - 1);
                for (int j = i - num; j < i - 1; j++) {
                    sb.append(words[j]);
                    sb.append(" ");
                    int counter = spaceNum;
                    while(counter > 0) {
                        sb.append(" ");
                        counter--;
                    }
                    if (spaceRedundant > 0) {
                        spaceRedundant--;
                        sb.append(" ");
                    }
                }
                sb.append(words[i - 1]);
            }
            list.add(sb.toString());
            num = 1;
            start = count[i];
            i++;
        }
        return list;
    }
}
