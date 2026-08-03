class Solution {
    public int reverse(int x) {
        int sign = 1;
        if(x < 0) {
            sign = -1;
        }
        x = Math.abs(x);
        long ans = 0;
        while(x > 0) {
            ans = ans*10 + x%10;
            x = x/10;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ans*sign;
    }
}