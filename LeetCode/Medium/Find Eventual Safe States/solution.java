class Solution {

    int[][] graph;
    int n;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        n = graph.length;
        this.graph = graph;

        int[] indegree = new int[n]; 

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            for(int node : graph[i]){
                adj.get(node).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        boolean[] safe = new boolean[n];

        while(!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for(int v : adj.get(node)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(safe[i]) {
                res.add(i);
            }
        }
        return res;
        
    }
}