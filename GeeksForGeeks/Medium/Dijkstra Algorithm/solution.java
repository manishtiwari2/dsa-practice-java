class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
       
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];
           
            graph.get(u).add(new int[]{v, d});
            graph.get(v).add(new int[]{u, d});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
       
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
        pq.offer(new int[]{src, 0});
       
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
           
            if(d > result[node]) {
                continue;
            }
            for(int[] pair : graph.get(node)) {
                int v = pair[0];
                int wt = pair[1];
               
                if(d + wt < result[v]) {
                    result[v] = d + wt;
                    pq.offer(new int[]{v, result[v]});
                }
           }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : result) {
            ans.add(i);
        }
       
       
        return ans;
    }
}