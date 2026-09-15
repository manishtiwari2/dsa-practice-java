class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }
    private int solve(int idx, int[] cost, int[] dp) { 
        if(idx >= cost.length) {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }

        return dp[idx] = cost[idx] + Math.min(
            solve(idx + 1, cost, dp), solve(idx + 2, cost, dp));
    }
}