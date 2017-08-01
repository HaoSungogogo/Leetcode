public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return new String();
        }
        char[] array = s.toCharArray();
        reverse(array, 0, array.length - 1);
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        int slow = 0;
        int fast = 0;
        // delete the heading, tailing and duplicated spaces.
        while (fast < array.length) {
            while (fast < array.length && array[fast] == ' ') {
                fast++;
            }
            while (fast < array.length && array[fast] != ' ') {
                array[slow++] = array[fast++];
            }
            while (fast < array.length && array[fast] == ' ') {
                fast++;
            }
            if (fast < array.length) {
                array[slow++] = ' ';
            }
        }
        return new String(array, 0, slow);
    }
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}