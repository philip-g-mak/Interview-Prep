class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet();
        
        int l = 0, r = 0;
        int maxLen = 0;
        
        while(l <= r && r < s.length()){
            if(!charSet.contains(s.charAt(r))){
                charSet.add(s.charAt(r));
                maxLen = Math.max(r - l + 1, maxLen);
                r++;
            } else {
                charSet.remove(s.charAt(l));
                l++;
            }
        }
        return maxLen;
    }
}

/*
idea - use hashset to check whether something was seen already

2 pointer approach

L and R pointer - left and right side
L and R both start at index 0

in loop while R is not at the end of the string and no overlap(?) 
    check if leter @ R index not in hashset
        true - increment
               update maxlength
        false - increment L
    
time O(n)
space O(n)

*/