class Solution {
    int majorityElement(int arr[]) {
        int candidate = 0;

        int count = 0;
        for(int num : arr) {
            if(count == 0) {
                candidate = num;
                count++;
            } else if(num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        int actual = 0;
        for(int num : arr) {
            if(num == candidate) {
                actual++;
            }
        }
        if(actual > arr.length/2) {
            return candidate;
        } else {
            return -1;
        }
    }
}