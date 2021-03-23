class Solution {
    Map<Integer, List<Integer>> numMap;
    Random rand = new Random();
    public Solution(int[] nums) {
        numMap = new HashMap();
        
        for(int i = 0; i < nums.length; i++){
            if(numMap.containsKey(nums[i])){
                numMap.get(nums[i]).add(i);
            } else {
                numMap.put(nums[i], new ArrayList(List.of(i)));
            }
        }
        
        
    }
    
    public int pick(int target) {
        return numMap.get(target).get(rand.nextInt(numMap.get(target).size()));
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

/*
Map 

 1 : 0
 2: 1
 3: 2 3 4

*/