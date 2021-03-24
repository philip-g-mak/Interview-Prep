class Solution {
    
    String[] lessThan20 = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen",};
    
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousand = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        String words = "";
        int i = 0;
        
        while(num > 0){
            if(num%1000 != 0){
                words = helper(num%1000) + thousand[i] + " " + words;
            }
            i++;
            num/=1000;
        }
        
        
        return words.trim();
        
    }
    
    public String helper(int num){
        if(num == 0) return "";
        
        if(num <20) return lessThan20[num] + " ";
        
        if(num < 100) return tens[num/10] + " " +  helper(num%10);
        
        return lessThan20[num/100] + " Hundred " + helper(num%100);
    }
}