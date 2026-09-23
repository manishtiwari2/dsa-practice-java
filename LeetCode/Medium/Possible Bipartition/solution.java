class Solution {

    List<List<Integer>> graph = new ArrayList<>();

    public boolean possibleBipartition(int n, int[][] dislikes) {

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : dislikes) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }

        int[] color = new int[n];

        for(int i = 0; i < n; i++) {
            if(color[i] != 0) {
                continue;
            }
            Deque<Integer> q = new ArrayDeque<>();
            color[i] = 1;
            q.offer(i);

            while(!q.isEmpty()) {
                int curr = q.poll();

                for(int v : graph.get(curr)) {
                    if(color[v] == 0) {
                        color[v] = 3 - color[curr];
                        q.offer(v);
                    }
                    if(color[v] == color[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}