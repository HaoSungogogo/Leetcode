/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int pointer = 0;
    private int content = 0;
    private int len;
    private char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int num = 0;
        while (num < n) {
            if (pointer == 0) {
                content = read4(buffer);
            }
            if (content == 0) {
                break;
            }
            len = Math.min(n - num, content - pointer);
            for (int i = 0; i < len; i++) {
                buf[num + i] = buffer[pointer + i];
            }
            num += len;
            pointer = len + pointer == content ? 0 : pointer + len;
        }
        return num;
    }
}
