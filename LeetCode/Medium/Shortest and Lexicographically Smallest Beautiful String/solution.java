class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int left = 0;
        int ones = 0;

        int bestStart = -1;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
            if (ones == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }
                int len = right - left + 1;

                if (len < bestLen) {
                    bestLen = len;
                    bestStart = left;
                } else if (len == bestLen) {
                    for (int i = 0; i < len; i++) {
                        char current = s.charAt(left + i);
                        char best = s.charAt(bestStart + i);

                        if (current < best) {
                            bestStart = left;
                            break;
                        } else if (current > best) {
                            break;
                        }
                    }
                }
            }
        }
        if (bestStart == -1) {
            return "";
        }
        return s.substring(bestStart, bestStart + bestLen);
    }
}