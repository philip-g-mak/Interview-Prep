class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabet = new int[26]; //numbered order of letters
        for(int i = 0; i < order.length(); i++){
            alphabet[order.charAt(i) - 'a'] = i; 
        }
        
        //i only need to look at two words at a time.  i, i+1.  if this is false at anytime, the entire thing is false
        
        
        for(int i = 0; i < words.length -1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            
            int compareLen = Math.min(word1.length(), word2.length());
            for(int j = 0; j < compareLen; j++){
                int char1 = word1.charAt(j) - 'a';
                int char2 = word2.charAt(j) - 'a';
                
                if(alphabet[char1] < alphabet[char2]){
                    break;
                } else if(alphabet[char1] > alphabet[char2]){
                    return false;
                } else if(j + 1 == compareLen && !word1.equals(word2) &&compareLen == word2.length()){
                    return false;
                }
            }
        }
        
        
        
        
        return true;
    }
}