class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                memo[i][j] = -1;
            }
        }
        return isInterleaveHelper(s1, 0, s2, 0, s3,0);
    }
    
    public boolean isInterleaveHelper(String s1, int i, String s2,int j, String s3, int k){
       if(i == s1.length()){
           return s2.substring(j).equals(s3.substring(k));
       }
        if(j == s2.length()){
           return s1.substring(i).equals(s3.substring(k));
       }
        if(memo[i][j] >= 0){
            return memo[i][j] == 1 ? true : false;
        }
        
        boolean ans = false;
        if(s3.charAt(k) == s1.charAt(i) && isInterleaveHelper(s1, i+1, s2, j, s3, k+1) ||s3.charAt(k) == s2.charAt(j) && isInterleaveHelper(s1, i, s2, j+1, s3, k+1)){
            ans = true;
        }
        
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}

/*
idea - check every combination recursively

when at the traversed all of s1 and s2 and the string you created is equal so s3 then true

keep recursing adding 1 char at a time from either


how to speed up - memoization or dp
*/