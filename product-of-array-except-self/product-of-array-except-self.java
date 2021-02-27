class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lp = new int[nums.length];
        int[] rp = new int[nums.length];
        
        lp[0]= 1;
        for(int i = 1; i < nums.length; i++){
            lp[i] = nums[i-1] * lp[i-1];
        }
        
        rp[nums.length -1]= 1;
        for(int i = nums.length -2; i >= 0; i--){
            rp[i] = nums[i+1] * rp[i+1];
        }
        
        for(int i = 0; i < nums.length; i++){
            lp[i] *= rp[i];
        }
        return lp;
        
    }
}

/*

get the left product and right product of each index

example - [1,2,3,4]
left prod - 1 , 1, 2, 6
right prod -24, 12, 4, 1 

answer = left[i] * right[i]

*/