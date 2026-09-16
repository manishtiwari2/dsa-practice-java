class Solution {

    int[] dp;

    public int numDecodings(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(0, s);
    }

    private int solve(int idx, String s) {

        if (idx == s.length()) {
            return 1;
        }
        if (s.charAt(idx) == '0') {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        int ans = solve(idx + 1, s);

        if (idx + 1 < s.length()) {

            int num = Integer.parseInt(s.substring(idx, idx + 2));
            if (num >= 10 && num <= 26) {
                ans += solve(idx + 2, s);
            }
        }
        return dp[idx] = ans;
    }
}