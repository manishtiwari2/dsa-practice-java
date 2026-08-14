class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];

        int left = 0;
        int ans = 0;

        for(int right = 0; right < s.length();right++) {
            char current = s.charAt(right);
            freq[current - 'a']++;
            while(check(freq)){
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            ans = Math.max(ans, right-left+1);
        } 
        return ans;
    }
    private boolean check(int[] arr) {
        for(int i=0; i<26; i++){
            if(arr[i] > 2) {
                return true;
            }
        }
        return false;
    }
}