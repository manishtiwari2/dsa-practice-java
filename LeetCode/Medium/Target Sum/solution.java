class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, nums, target);
    }
    private int solve(int idx, int sum, int[] nums, int target) {
        if(idx == nums.length) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        return solve(idx + 1, sum + nums[idx], nums, target) + 
                solve(idx + 1, sum - nums[idx], nums, target);
    }
}