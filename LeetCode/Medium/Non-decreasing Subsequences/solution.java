class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums,0,new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int idx, List<Integer> curr) {
        if(curr.size() >= 2) {
            result.add(new ArrayList<>(curr));
        }
        Set<Integer> set = new HashSet<>();
        for(int i=idx; i<nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            if(!curr.isEmpty() && nums[i] < curr.get(curr.size()-1)){
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums,i+1,curr);
            curr.remove(curr.size()-1);
            set.add(nums[i]);
        }
    }
}