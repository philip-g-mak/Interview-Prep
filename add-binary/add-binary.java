import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        if(a.equals("0")) return b;
        if(b.equals("0")) return a;
        
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        
        BigInteger zero = new BigInteger("0",2);
        BigInteger answer = new BigInteger("0",2);
        BigInteger carry = new BigInteger("0",2);
        
       while(y.compareTo(zero) != 0){
            answer = x.xor(y);
            carry = (x.and(y)).shiftLeft(1);
            
            x = answer;
            y = carry;
        } 
        
        return answer.toString(2);
    }
}
/*
sum without carry 
111
111
---
000

just the carry elements
111

actual answer is 

1110

while(justTheCarry has a value > 0)
    sumWithoutCarry  = sumWithoutCarry ^ justTheCarry
    justTheCarry = (a & b ) << 1
    
    
*/