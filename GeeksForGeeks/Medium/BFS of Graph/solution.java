class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> result = new ArrayList<>();
        int n = adj.size();
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            
            for(int v : adj.get(curr)) {
                if(!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
        return result;
        
    }
}