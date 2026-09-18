class Solution {
    
    static ArrayList<Integer> res;
    static ArrayList<ArrayList<Integer>> graph;
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
        int n = adj.size();
        graph = adj;
        res = new ArrayList<>();
        boolean[] visited = new boolean[n];

        dfs1(0, visited);
        return res;
        
    }
    private void dfs1(int node, boolean[] visited) {
        if(visited[node]){
            return;
        }
        visited[node] = true;
        res.add(node);

        for(int v : graph.get(node)) {
            dfs1(v, visited);
        }
    }
}