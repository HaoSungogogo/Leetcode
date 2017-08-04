//StringBuilder array to solve
// two operations over and over again (put them in the loop)
public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int j = 0; j < numRows; j++) {
            sb[j] = new StringBuilder();
        }
        char[] array = s.toCharArray();
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < numRows && i < array.length; j++) {
                sb[j].append(array[i++]);
            }
            for (int j = numRows - 2; j >= 1 && i < array.length; j--) {
                sb[j].append(array[i++]);
            }
        }
        for(int j = 1; j < numRows; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}
