class Solution {
    public int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE;
        int t2Cost = Integer.MAX_VALUE;
        
        int t1Profit = 0;
        int t2Profit = 0;
        
        for(int price : prices){
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price-t1Cost);
            t2Cost = Math.min(t2Cost, price-t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost); 
        }
        
        return t2Profit;
    }
}

/*
idea - two transactions

maximize transaction 1

then use the profit of transation 1 to reinvest and sell 
    - reinvest so we're trying to find the minimum of price - t1profit (t1 profit offsets this price)
*/