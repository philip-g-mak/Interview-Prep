class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCount = new HashMap();
        Map<Character, Integer> sCount = new HashMap();
        
        List<Integer> ret = new LinkedList();
        if(s.length() < p.length()) return ret;
        
        
        for(char c : p.toCharArray()){
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            sCount.put(ch, sCount.getOrDefault(ch, 0)+1);
            
            if( i >= p.length()){
                ch = s.charAt(i - p.length());
                if(sCount.get(ch) == 1){
                    sCount.remove(ch);
                } else {
                    sCount.put(ch, sCount.getOrDefault(ch, 0)-1);
                }
            }
            
            if(pCount.equals(sCount)){
                ret.add(i - p.length() +1);
            }
        }
        return ret;
    }
    
  
}