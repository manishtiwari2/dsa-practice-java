class Solution {

    int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};

    public int minCost(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        
        int[][] dist = new int[R][C];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,0});
        dist[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            if(cost > dist[r][c]) {
                continue;
            }

            if(r == R-1 && c == C-1) {
                return cost;
            }

            for(int d = 0; d < 4; d++) {

                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }

                int moveCost = (grid[r][c] == d + 1) ? 0 : 1;
                int newCost = cost + moveCost;

                if(newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new int[]{nr, nc, newCost});
                }
            }
        }
        return -1;
    }
}