class Solution {

    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : roads) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph.get(u).add(new int[]{v, wt});
            graph.get(v).add(new int[]{u, wt});
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] edge : graph.get(u)) {

                int v = edge[0];
                int wt = edge[1];

                long newDist = d + wt;

                if (newDist < dist[v]) {

                    dist[v] = newDist;
                    ways[v] = ways[u];

                    pq.offer(new long[]{v, newDist});
                }
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}