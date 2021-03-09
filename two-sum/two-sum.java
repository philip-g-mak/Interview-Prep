class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complimentMap = new HashMap();
        
        int compliment;
        int ret[] = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            compliment = target - nums[i];
            if(complimentMap.containsKey(compliment)){
                ret[0] = i;
                ret[1] = complimentMap.get(compliment);
                break;
            }
            
            complimentMap.put(nums[i], i);
        }
        return ret;
    }
}