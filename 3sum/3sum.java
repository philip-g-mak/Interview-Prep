class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){ //skip a duplicates
                continue;
            }
            
            int j = i+1, k = nums.length -1;
            int target = -nums[i];
            
            while(j < k){
                if(nums[j]+ nums[k] == target){
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                    
                    while(j < k && nums[j] == nums[j-1]){ //skip b duplicates
                        j++;
                    }
                    while(j < k && nums[k] == nums[k+1]){ //skip b duplicates
                        k--;
                    }
                    
                } else if( nums[j] + nums[k] >  target){
                    k--;
                }else {
                    j++;
                }
            }
        }
        
        
        
        return ret;
    }
}

/*
idea - sort the numbers 

a + b + c = 0
a + b = -c

look for tripples such that match that match that criteria
Must be UNIQUE TRIPLES

best i think is n^2 time

other way if i dont care about space

n - calls of 2 sum w/hashmap
*/