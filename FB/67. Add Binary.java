class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int m = A.length - 1;
        int n = B.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(m >= 0 && n >= 0) {
            int sum = A[m] - '0' + B[n] - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            m--;
            n--;
        }
        while (m >= 0) {
            int sum = A[m] - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            m--;
        }
        while (n >= 0) {
            int sum = B[n] - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            n--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
