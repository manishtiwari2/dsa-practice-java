class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        int INF = 100000000;

        int[] result = new int[V];
        Arrays.fill(result, INF);
        result[src] = 0;

        // Relax edges V - 1 times
        for (int i = 0; i < V - 1; i++) {

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (result[u] != INF &&
                    result[u] + wt < result[v]) {

                    result[v] = result[u] + wt;
                }
            }
        }

        // Check for negative-weight cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (result[u] != INF &&
                result[u] + wt < result[v]) {

                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(-1);
                return ans;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int d : result) {
            ans.add(d);
        }

        return ans;
    }
}