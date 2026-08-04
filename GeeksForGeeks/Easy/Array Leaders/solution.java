import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        int maxTill = arr[n - 1];
        ans.add(maxTill);
        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxTill) {
                maxTill = arr[i]; 
                ans.add(arr[i]);  
            }
        }
        
        Collections.reverse(ans); 
        return ans;
    }
}
