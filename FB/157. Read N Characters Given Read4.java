/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int num = 0;
        while (num < n) {
            int count = read4(buffer);
            int len = Math.min(n - num, count);
            for (int i = 0; i < len; i++) {
                buf[num + i] = buffer[i];
            }
            num += len;
            if (count != 4) {
                break;
            }
        }
        return num;
    }
}
