class Solution {
    public boolean isNumber(String s) {
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberSeenAfterE = false;
        
        for(int i = 0; i < s.length(); i++){
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                numberSeen = true;
                numberSeenAfterE = true;
            } else if(s.charAt(i) == '.'){
                if(eSeen || pointSeen) return false;
                    else pointSeen = true;
            } else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if(eSeen || !numberSeen) return false;
                        eSeen = true;
                        numberSeenAfterE = false;
                } else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                    if(i!=0 && s.charAt(i-1) != 'e') return false;
                } else return false;
            }
        return numberSeen && numberSeenAfterE;
    }
}