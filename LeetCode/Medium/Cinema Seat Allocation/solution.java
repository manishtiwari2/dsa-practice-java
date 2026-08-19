class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                if(!map.containsKey(row)){
                    map.put(row, new HashSet<>());
                }
                map.get(row).add(col);
            }
        }
        int ans = (n-map.size())*2;
        for(Set<Integer> seats : map.values()) {
            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for(int seat : seats) {
                if(seat >= 2 && seat <= 5) {
                    left = false;
                }
                if(seat >= 4 && seat <= 7) {
                    middle = false;
                }
                if(seat >= 6 && seat <= 9) {
                    right = false;
                }
            }
            if(left && right) {
                ans += 2;
            } else if(left || middle || right){
                ans += 1;
            }
        }
        return ans;
    }
}
