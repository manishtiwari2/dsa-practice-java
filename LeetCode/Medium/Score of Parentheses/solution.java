class Solution {
    public int scoreOfParentheses(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        int score = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                st.push('(');
            } else {
                st.pop();
                if (s.charAt(i - 1) == '(') {
                    score += 1 << st.size(); 
                }
            }
        }
        return score;
    }
}