class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) {
                continue;
            }

            Deque<Integer> q = new ArrayDeque<>();
            color[i] = 1;
            q.offer(i);

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int v : graph[curr]) {

                    if (color[v] == 0) {
                        color[v] = 3 - color[curr];
                        q.offer(v);
                    }
                    else if (color[v] == color[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}