class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];
        
        if(s.length() != t.length())return false;
        
        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) -'a']++;
            charCount[t.charAt(i) -'a']--;
        }
        
        for(int i =0; i < charCount.length; i++){
            if(charCount[i]!= 0) return false;
        }
        return true;
    }
}

/*
only lowercase alphabet so 26 letters
create int array size 26 

increment
then decrement

check if any value is not 0
*/