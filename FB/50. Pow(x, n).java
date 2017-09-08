class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return power(x, n);
        } else {
            if (n == Integer.MIN_VALUE) {
                return power(1 / x, -(n + 1)) / x;
            }
            return power(1 / x, -n);
        }
    }
    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = power(x, n / 2);
        if (n % 2 == 1) {
            return temp * temp * x;
        } else {
            return temp * temp;
        }
    }
}
