Simulate multiplication one number by number and put the res into right position of return array.

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        char[] one = num1.toCharArray();
        char[] two = num2.toCharArray();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (one[i] - '0') * (two[j] - '0');
                int pos1 = i + j + 1;
                int sum = mul + res[pos1];
                res[pos1] = sum % 10;
                int carry = sum / 10;
                while (carry > 0) {
                	pos1--;
                  res[pos1] += carry;
                  carry = res[pos1] / 10;
                  res[pos1] = res[pos1] % 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (sb.length() == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
