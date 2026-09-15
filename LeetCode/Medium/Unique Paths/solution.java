class Solution {

    int mm;
    int nn;

    public int uniquePaths(int m, int n) {
        mm = m;
        nn = n;
        int[][] dp = new int[mm][nn];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return solve(0,0, dp);
    }
    private int solve(int i, int j, int[][] dp) {
        if(i >= mm || j >= nn){
            return 0;
        }
        if(i == mm - 1 && j == nn - 1) {
            return 1;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = solve(i + 1, j, dp) + solve(i, j + 1, dp);
    }
}