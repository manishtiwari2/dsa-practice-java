class Solution {
    public int smallestNumber(int n, int t) {
        
        while (true) {
            int curr = product(n);
            if (curr % t == 0) {
                return n;
            }
            n++;
        }
    }

    private int product(int n){
        int ans = 1;
        while(n>0) {
            int curr = n%10;
            ans *= curr;
            n = n/10;
        }
        return ans;
    }

}