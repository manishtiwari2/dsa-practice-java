class Solution {

    static int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};

    int m;
    int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int ans = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(int i, int j, char[][] grid) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            dfs(nr, nc, grid);
        }
    }
}