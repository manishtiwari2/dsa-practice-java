class Solution {
    int[][] graph;
    int n;
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        graph = isConnected;
        n = graph.length;

        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(i, visited);
                ans++;
            }
        }
        return ans;
    }
    private void bfs(int node, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(int i = 0; i<n; i++) {
                if(graph[curr][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}