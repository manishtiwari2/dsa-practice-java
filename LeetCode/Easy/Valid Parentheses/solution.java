class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();


        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else  {
                if(st.isEmpty()) {
                    return false;
                }  else if(map.get(st.pop()) != ch) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}