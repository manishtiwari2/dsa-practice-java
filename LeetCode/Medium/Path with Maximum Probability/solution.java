class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<double[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            
            graph.get(u).add(new double[]{v, p});
            graph.get(v).add(new double[]{u, p});
            
        }

        double[] prob = new double[n];
        prob[start_node] = 1.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[1],a[1]));
        pq.offer(new double[]{start_node, 1.0});

        while(!pq.isEmpty()) {
            double[] curr = pq.poll();

            int node = (int) curr[0];
            double p = curr[1];

            if(p < prob[node]){
                continue;
            }
            for(double[] next : graph.get(node)){

                int v = (int) next[0];
                double currP = next[1];

                if(p*currP > prob[v]) {
                    prob[v] = p*currP;
                    pq.offer(new double[]{v, prob[v]});
                }
            }
        }
        return prob[end_node];

    }
}