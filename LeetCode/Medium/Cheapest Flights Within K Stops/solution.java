class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int[] curr;
        
        for(int i = 0; i < k+1; i++) {
            curr = dist.clone();

            for(int[] edge : flights) {

                int u = edge[0];
                int v = edge[1];
                int d = edge[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + d < curr[v]) {
                    curr[v] = dist[u] + d;
                }
            }
            dist = curr;
        } 
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
        
    }
}