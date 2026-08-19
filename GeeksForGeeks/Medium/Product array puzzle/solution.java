class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] result = new int[n];
        
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }
        
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;

            suffixProduct *= arr[i];
        }
        return result;
        
    }
}

