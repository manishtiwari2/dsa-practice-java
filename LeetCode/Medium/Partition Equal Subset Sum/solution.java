class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int num : nums) {
            total += num;
        }
        if(total % 2 != 0) {
            return false;
        }
        int target = total/2;

        Boolean[][] dp = new Boolean[n][target+1];

        return solve(0, target, nums, dp);
    }
    private boolean solve(int idx, int target, int[] nums, Boolean[][] dp) {
        if(target == 0) {
            return true;
        }
        if(idx == nums.length) {
            return false;
        }
        if(dp[idx][target] != null) {
            return dp[idx][target];
        }

        if(nums[idx] > target) {
            return dp[idx][target] = solve(idx + 1, target, nums, dp);
        }
        return dp[idx][target] = solve(idx + 1, target, nums, dp) || solve(idx + 1, target - nums[idx], nums, dp);
    }
}