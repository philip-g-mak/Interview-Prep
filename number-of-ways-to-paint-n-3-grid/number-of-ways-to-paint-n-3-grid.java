class Solution {
    public int numOfWays(int n) {
        int MOD = (int) Math.pow(10,9) + 7;
        
        long col3 = 6;
        long col2 = 6;
        
        for(int i = 2; i <= n; i++){
            long temp3Col = col3;
            col3 = (2*col3 + 2*col2)%MOD;
            col2 = (2*temp3Col + 3*col2)%MOD;
        }
        
        return (int)(col3 + col2)% MOD;
    }
}

/*


given a block, there are 6 3-color patterns and 6 2-color patterns


if a block is 3color 
    then the next possible blocks are 2 3-color or 2 2-color
    ryg -> ygr, gry 
        -> yry, ygy
    

if a block is 2color 
    then the next possible blocks are 2 3-color or 3 2-color
    ryr -> yrg, gry 
        ->  ygy  grg  yry  
    
we can make this into 2 equations

3color(n+1) = 2* 3color(n) + 2*2color(n)
2color(n+1) = 2* 3color(n) + 3*2color(n)


*/