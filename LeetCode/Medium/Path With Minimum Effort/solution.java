class Solution {

    int R;
    int C;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};

    public int minimumEffortPath(int[][] heights) {

        R = heights.length;
        C = heights[0].length;

        int[][] result = new int[R][C];
        
        for(int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        result[0][0] = 0;
        pq.offer(new int[]{0,0,0});

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int effort = curr[2];

            if(r == R - 1 && c == C - 1) {
                return effort;
            }
            if(effort > result[r][c]) {
                continue;
            }
            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                    
                }
                int newEffort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));

                if(newEffort < result[nr][nc]) { 
                    result[nr][nc] = newEffort;
                    pq.offer(new int[]{nr, nc, newEffort});
                }
            }
        }
        return 0;
    }
}