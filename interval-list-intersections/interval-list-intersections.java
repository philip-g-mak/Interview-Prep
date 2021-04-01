class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ret = new ArrayList();
        
        int idx1 = 0;
        int idx2 = 0;
        
        while(idx1 < firstList.length && idx2 < secondList.length){
            int lo = Math.max(firstList[idx1][0],secondList[idx2][0]);
            int hi = Math.min(firstList[idx1][1],secondList[idx2][1]);
            
            if(lo <= hi){
                ret.add(new int[]{lo, hi});
            }
            
            if(firstList[idx1][1] < secondList[idx2][1])
                idx1++;
            else
                idx2++;
            
            
            
        }
        
        return ret.toArray(new int[ret.size()][2]);
    }
}