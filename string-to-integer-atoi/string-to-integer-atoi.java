class Solution {
    public int myAtoi(String s) {
        double val = 0;
        int readIndex = 0;
        boolean isNegative = false;
        //remove leading and trailing white space
        s=s.trim();
        
        if(s.length() == 0){
            return 0;
        }
        
        if(s.charAt(readIndex) == '-'){
            isNegative = true;
            readIndex++;
        
        } else if (s.charAt(readIndex) == '+'){
            isNegative = false;
            readIndex++;
            
        }
        
        while(readIndex < s.length() && Character.isDigit(s.charAt(readIndex))){
            val = val*10 + (s.charAt(readIndex)-'0');
            readIndex++;
            
            //check if out of bounds
            
            
        }
        
        if(isNegative){
            val *= -1;
        }
        if(val > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        if(val < Integer.MIN_VALUE)
            return Integer.MIN_VALUE ;
    
      
        
        return (int)val;
    }
}