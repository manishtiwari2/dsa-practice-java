class Solution {
    int noObs;
    int result = 0;
    int m;
    int n;

    int[][] dircs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int stR = 0;
        int stC = 0;
        noObs = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0;j<n; j++) {
                if(grid[i][j] == 0) {
                    noObs++;
                }
                else if(grid[i][j] == 1) {
                    stR = i;
                    stC = j;
                }
            }
        }
        noObs++;
        
        backtrack(grid,0,stR,stC);
        return result;
    }
    void backtrack(int[][] grid, int curr, int i, int j){
        if(i<0 || i >= m || j < 0 || j >= n || grid[i][j]==-1){
            return;
        }
        if(grid[i][j] == 2) {
            if(curr == noObs){
                result++;
            }
            return;
        }
        grid[i][j] = -1;

        for(int[] dir : dircs ) {
            int nR = i + dir[0];
            int nC = j + dir[1];

            backtrack(grid,curr+1,nR,nC);
        }
        grid[i][j] = 0;
    }

}