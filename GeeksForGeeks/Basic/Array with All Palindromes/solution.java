class Solution {
    public static boolean isPalinArray(int[] arr) {
        for(int num : arr) {
            if(!isPalindrome(num)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome(int n) {
        
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