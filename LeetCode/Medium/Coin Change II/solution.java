class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, amount, coins, dp);
    }
    private int solve(int idx, int target, int[] coins, int[][] dp) {
        if(target == 0) {
            return 1;
        }
        if(idx == coins.length) {
            return 0;
        }
        if(dp[idx][target] != -1) {
            return dp[idx][target];
        }
        if(coins[idx] <= target) {
            return dp[idx][target] = solve(idx + 1, target, coins, dp) + solve(idx, target - coins[idx], coins, dp);
        }
        return dp[idx][target] = solve(idx + 1, target, coins, dp);
    }
}