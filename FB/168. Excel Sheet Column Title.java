class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return new String();
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + (n % 26)));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
