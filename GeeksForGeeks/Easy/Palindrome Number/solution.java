class Solution {
    public boolean isPalindrome(int n) {
        
        n = Math.abs(n);
        
        if(n%10 == 0 && n != 0){
            return false;
        }
        int orig = n;
        int rev = 0;
        
        while(n>rev) {
            rev = (rev*10) + n%10;
            n = n/10;
        }
        return rev == n || rev/10 == n;
    }
}