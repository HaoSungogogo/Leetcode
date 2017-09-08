class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return new String();
        }
        if (n == 1) {
            return new String("1");
        }
        String s = countAndSay(n - 1);
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < array.length) {
            int count = 1;
            while (i < array.length - 1 && array[i] == array[i + 1]) {
            	count++;
            	i++;
            }
            sb.append(count);
            sb.append(array[i]);
            i++;
        }
        return sb.toString();
    }
}
