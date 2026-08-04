class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE; 
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }
        for(int i = min+1; i<=max; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
        
    }
}