class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int mx = nums[i];
            int mn = nums[i];

            for (int j = 0; j < i; j++) {
                mx = Math.max(mx, nums[j]);
            }
            for (int j = i + 1; j < n; j++) {
                mn = Math.min(mn, nums[j]);
            }
            if (mx - mn <= k) {
                return i;
            }
        }
        return -1;
    }
}