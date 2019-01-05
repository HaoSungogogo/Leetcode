Similar to dp thinking, using two arrays,
nextIdx[i] represents, if starting with the ith sentence in the new line, the index of sentence to the nextline.
times[i] represents, if starting with the ith sentence in the new line, the number of times that we traverse all the sentence

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextIdx = new int[sentence.length];
        int[] times = new int[sentence.length];
        int res = 0;
        for (int i = 0; i < sentence.length; i++) {
            int curlen = 0;
            int cur = i;
            int time = 0;
            while (curlen + sentence[cur].length() <= cols) {
                curlen += sentence[cur++].length() + 1;
                if (cur == sentence.length) {
                    cur = 0;
                    time++;
                }
            }
            nextIdx[i] = cur;
            times[i] = time;
        }
        int cur = 0;
        for (int i = 0; i < rows; i++) {
            res += times[cur];
            cur = nextIdx[cur];
        }
        return res;
    }
}
