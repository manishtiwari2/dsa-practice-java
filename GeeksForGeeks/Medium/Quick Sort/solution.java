class Solution {
    public void quickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int pivotIdx = partition(arr,low,high);
        
        quickSort(arr,low,pivotIdx-1);
        quickSort(arr,pivotIdx+1,high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivotIdx = low;
        
        for(int i=low; i<high; i++){
            if(arr[i] <= pivot){
                swap(arr,i,pivotIdx);
                pivotIdx++;
            }
        }
        swap(arr,pivotIdx,high);
        return pivotIdx;
        
    }
    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}