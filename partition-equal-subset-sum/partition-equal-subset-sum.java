class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        
        for(int num : nums) target+= num;
        
        if(target % 2 == 1) return false;

        target/=2;
        
        
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        
        for(int i = 1; i < nums.length + 1; i++){
            int currNum = nums[i-1];
            
            for(int j = 0; j <= target; j++){
                if(j < currNum){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-currNum]; 
                }
            }
        }
        
        return dp[nums.length][target];
    }
}

/*
idea - only need to find sum/2
and only if possible


so dp problem??

go through all inputs and build off of what could be reached 

*/