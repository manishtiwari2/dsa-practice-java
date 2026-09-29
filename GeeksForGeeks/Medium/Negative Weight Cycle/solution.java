class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        
        int[] dist = new int[V];
        
        for(int i = 0; i < V-1; i++){
            for(int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int d = edge[2];
                
                if(dist[u] + d < dist[v]){
                    dist[v] = dist[u] + d;
                }
            }
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];
            
            if(dist[u] != Integer.MAX_VALUE && dist[u] + d < dist[v]){
                return true;
            }
        }
        return false;
    }
}