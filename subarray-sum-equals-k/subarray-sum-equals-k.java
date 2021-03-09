class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // {Sum, # of occurence of Sum}
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        int count = 0;
        
        map.put(0,1);
        
        for(int i = 0; i < nums.length; i++){
            sum+= nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
            

        }
        
        return count;
    }
}

/*

    S[i, j] = k  i < j

    S[0, j] - S[0, i] = S[i , j]

    S[0, j] - S[0, i] = k
    S[0, j] = k + S[0, i]

    S[0,i] = S[0, j] - k

*/