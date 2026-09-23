class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];

        for(int[] edge : trust) {
            int a = edge[0];
            int b = edge[1];

            indegree[b]++;
        }
        int cand = -1;
        for(int i = 1;i<n+1; i++){
            if(indegree[i] == n-1) {
                cand = i;
            }
        }
        for(int[] edge : trust) {
            int a = edge[0];
            int b = edge[1];

            if(cand == a) {
                return -1;
            }
        }
        return cand;
        
    }
}