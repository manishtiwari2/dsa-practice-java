class Solution {

    int m;
    int n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] grid = obstacleGrid;
        m = grid.length;
        n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return solve(0,0, dp, grid);
        
    }
    private int solve(int i, int j, int[][] dp, int[][] grid) {
        if(i >= m || j >= n || grid[i][j] == 1){
            return 0;
        }
        if(i == m - 1 && j == n - 1) {
            return 1;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = solve(i + 1, j, dp, grid) + solve(i, j + 1, dp, grid);
    }
}
