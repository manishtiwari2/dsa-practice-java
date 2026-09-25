class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : times) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
        }
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k-1,0});
        weight[k-1] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            for(int[] v : graph.get(u)) {
                int node = v[0];
                int wt = v[1];

                if(d + wt < weight[node]) {
                    weight[node] = wt + d;
                    pq.offer(new int[]{node, weight[node]});
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(weight[i] == Integer.MAX_VALUE){
                return -1;
            } else {
                max = Math.max(max, weight[i]);
            }
        }
        return max;
    }
}