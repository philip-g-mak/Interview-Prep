class Solution {
    String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        
        int i = 0;
        String words="";
        while(num > 0){
            if(num %1000 != 0){
                words = helper(num%1000) +  thousands[i] + " " + words;
            }
            
            num/=1000;
            i++;
        }
        
        return words.trim();
    }
    
    public String helper(int num){
        if(num == 0) return "";
        
        if(num < 20) return lessThan20[num] + " ";
        
        if(num < 100) return tens[num/10] + " " + helper(num%10);
        
        if(num<1000) return lessThan20[num/100] + " Hundred " + helper(num%100);
        
        return "";
    }
}

/*
break it into parts and call recursively

thousand - million - billion

call helper method on the num%1000 
 to get the hundred tens ones

*/