class Solution {
    public int tribonacci(int n) {
        int[] dp = {0,1,1};
        
        for(int i = 3; i <= n; i++){
            dp[i %3] = dp[0] + dp[1] + dp[2];
        }
        
        return dp[n%3];
    }
}

/*
idea - only need to store the 3 last values to compute the next

store n values 0 to 3 in dp array

Then replace those values to compute new ones
*/