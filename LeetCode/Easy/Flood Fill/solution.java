class Solution {

    static int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0},{-1,0}};
    int m;
    int n;
    int original;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        m = image.length;
        n = image[0].length;

        original = image[sr][sc];
        if(original == color) {
            return image;
        }
        dfs(sr, sc, image, color);

        return image;
    }
    private void dfs(int sr, int sc, int[][] image, int color){

        if(sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != original) {
            return;
        }
        image[sr][sc] = color;

        for(int[] dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];

            dfs(r, c, image, color);
        }
    }
}