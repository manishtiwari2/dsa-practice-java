class Solution {

    List<List<Integer>> graph;
    int countN;
    int countE;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int ans = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {

            countN = 0;
            countE = 0;

            if (!vis[i]) {
                dfs(i, vis);

                if (isComplete(countN, countE / 2)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int node, boolean[] vis) {

        vis[node] = true;
        countN++;

        for (int v : graph.get(node)) {

            countE++;
            if (!vis[v]) {
                dfs(v, vis);
            }
        }
    }

    private boolean isComplete(int n, int e) {
        return e == n * (n - 1) / 2;
    }
}