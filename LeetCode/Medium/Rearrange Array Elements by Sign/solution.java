class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int[] ans = new int[nums.length];
        int p = 0, n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                ans[i] = pos.get(p++);
            } else {
                ans[i] = neg.get(n++);
            }
        }
        return ans;
    }
}