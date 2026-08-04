class Solution {
    public int minOperations(int[] nums) {

        int count = 0;
        int prev = 0;

        for(int curr : nums) {
            if(curr <= prev) {
                count += ++prev - curr;
            }
            else {
                prev = curr;
            }
        }
        return count;
    }
}