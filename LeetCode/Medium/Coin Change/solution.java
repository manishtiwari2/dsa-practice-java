class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        
        int ans = solve(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int solve(int[] coins, int target, int[] dp) {
        if(target == 0) {
            return 0;
        }
        if(dp[target] != -1) {
            return dp[target];
        }
        int ans = Integer.MAX_VALUE;

        for(int coin : coins) {
            if(coin <= target) {
                int result = solve(coins, target - coin, dp);

                if (result != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + result);
                }
            }
        }
        return dp[target] = ans;
    }
}