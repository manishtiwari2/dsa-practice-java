class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        if(t.length() < s.length()) {
            return false;
        }
        int first = 0;
        int second = 0;

        while(second < t.length()) {
            if(s.charAt(first) == t.charAt(second)){
                first++;
                if(first == s.length()) {
                    return true;
                }
            } 
            second++;
        }
        return false;
    }
}