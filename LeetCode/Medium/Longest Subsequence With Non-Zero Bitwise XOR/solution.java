class Solution {
    public int longestSubsequence(int[] nums) {
        
        int n = nums.length;
        int total = 0;
        boolean all = true;

        for(int num : nums) {
            total = total^num;
            if(num > 0){
                all = false;
            }
        }
        if(total > 0) {
            return n;
        }
        return all ? 0 : n-1;
    }
}
