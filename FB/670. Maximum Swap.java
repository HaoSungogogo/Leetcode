Record the last position to appear.
Traverse the num, when there exists one location of digit number is smaller than the location of larger digit number

class Solution {
    public int maximumSwap(int num) {
        char[] array = Integer.toString(num).toCharArray();
        int[] bucket = new int[10];
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] - '0'] = i;
        }
        for (int i = 0; i < array.length; i++) {
            for (int k = 9; k > array[i] - '0'; k--) {
                if (bucket[k] > i) {
                    char temp = array[i];
                    array[i] = array[bucket[k]];
                    array[bucket[k]] = temp;
                    return Integer.valueOf(new String(array));
                }
            }
        }
        return num;
    }
}
