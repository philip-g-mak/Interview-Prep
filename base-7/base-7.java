class Solution {
    public String convertToBase7(int num) {
        String ret = "";
        
        boolean isNeg = num < 0 ? true : false;
        num = Math.abs(num);
        
        do{
            ret = (num % 7) + ret;
            num /= 7;
        }while(num > 0);
        
        if(isNeg) ret = "-" + ret;
            
        return ret;
    }
}