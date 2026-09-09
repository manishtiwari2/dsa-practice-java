class Solution {
    public double myPow(double x, int n) {
        long pow = n;

        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }
        return power(x, pow);
    }

    private double power(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        if (n == 1) {
            return x;
        }
        double half = power(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}