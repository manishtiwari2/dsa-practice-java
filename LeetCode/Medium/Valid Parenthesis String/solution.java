class Solution {

    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length() + 1];
        return solve(s, 0, 0, dp);
    }

    private boolean solve(String s, int i, int balance, Boolean[][] dp) {

        if (balance < 0) {
            return false;
        }

        if (i == s.length()) {
            return balance == 0;
        }
        if(dp[i][balance] != null) {
            return dp[i][balance];
        }
        char c = s.charAt(i);

        if (c == '(') {
            return dp[i][balance] = solve(s, i + 1, balance + 1, dp);
        }

        if (c == ')') {
            return dp[i][balance] = solve(s, i + 1, balance - 1, dp);
        }
        boolean left = solve(s, i + 1, balance + 1, dp);
        boolean right = solve(s, i + 1, balance - 1, dp);
        boolean none = solve(s, i + 1, balance, dp);
        
        return dp[i][balance] = left || right || none;
    }
}