class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap();
        
        int l = 0, r = 0;
        int maxLen = 0;
        
        while(l <= r && r < s.length()){
            if(charMap.containsKey(s.charAt(r))){
                l= Math.max(charMap.get(s.charAt(r)), l);
            } 

            maxLen = Math.max(r - l + 1, maxLen);
            charMap.put(s.charAt(r), r+1);

            r++;

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

improved way using a hashmap
idea- same as before except we store the location of each letter in a map <letter : index>
      when we find a repeating character, we jump L pointer forward
      L  R
      abcbzxy

*/