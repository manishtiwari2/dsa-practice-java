import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        coins = Arrays.stream(coins).distinct().toArray();
        Arrays.sort(coins);

        List<Integer> useful = new ArrayList<>();

        for (int coin : coins) {
            boolean redundant = false;

            for (int x : useful) {
                if (coin % x == 0) {
                    redundant = true;
                    break;
                }
            }
            if (!redundant) {
                useful.add(coin);
            }
        }
        coins = useful.stream().mapToInt(Integer::intValue).toArray();

        long lo = 1;
        long hi = (long) coins[0] * k;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (count(mid, coins) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private long count(long x, int[] coins) {
        int n = coins.length;
        long result = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            boolean overflow = false;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    long g = gcd(lcm, coins[i]);
                    long multiplier = coins[i] / g;

                    if (lcm > x / multiplier) {
                        overflow = true;
                        break;
                    }
                    lcm *= multiplier;
                }
            }
            if (overflow || lcm > x) {
                continue;
            }

            long contribution = x / lcm;
            if ((bits & 1) == 1) {
                result += contribution;
            } else {
                result -= contribution;
            }
        }
        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}