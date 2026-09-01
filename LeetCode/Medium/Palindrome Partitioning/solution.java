class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(s, 0, result, current);

        return result;
    }

    void backtrack(String s, int idx,
                   List<List<String>> res,
                   List<String> current) {

        if (idx == s.length()) {res.add(new ArrayList<>(current));
            return;
        }
        for (int i = idx; i < s.length(); i++) {

            if (isPalindrome(s, idx, i)) {
                current.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, res, current);
                current.remove(current.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}