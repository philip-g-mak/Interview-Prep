public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap <> ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}
/*
[a,b] where sum of [a,b]= k

[a,b] = k = sum [0,b] - sum[0,a]

sum[0,b] = running sum -> store value in hashmap
see if complement(sum[0,b] - k) exists in hashmap implies that we saw sum[0,a]
*/