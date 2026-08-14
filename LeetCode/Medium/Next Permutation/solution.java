class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. Find the pivot
        int idx = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // 2. If no pivot, this is the last permutation
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // 3. Find the smallest element greater than nums[idx]
        //    Since suffix is decreasing, scan from right.
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        // 4. Reverse the suffix
        reverse(nums, idx + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
