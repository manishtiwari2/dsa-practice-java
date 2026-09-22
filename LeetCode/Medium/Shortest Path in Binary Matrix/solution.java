class Solution {

    int n;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        n = grid.length;

        if(grid[0][0] == 1) {
            return -1;
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if(r == n-1 && c == n-1){
                return dist;
            }

            for(int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;

                if(nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                if(grid[nr][nc] == 1) {
                    continue;
                }
                grid[nr][nc] = 1;
                q.offer(new int[]{nr, nc, dist+1});
            }
        }
        return -1;
    }
}