class Solution {
    int[][] steps = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[grid.length][grid.length];
        pq.add(new int[]{0,0, grid[0][0]});
        
        visited[0][0]= true;
        
        int time = 0;
        
        while(!pq.isEmpty()){
            int[] cord = pq.poll();
            for(int[] step :  steps){
                int x = cord[0] + step[0];
                int y = cord[1] + step[1];
                
                if(x < 0 || y < 0 || x >= grid.length || y >= grid.length || visited[x][y]) continue;
                
                visited[x][y] = true;
                
                time = Math.max(cord[2], grid[x][y]);
                if(x == grid.length - 1 && y == grid.length -1) return time;
                
                pq.add(new int[]{x,y,time});
                
                
            }
        }
        
        
        
        return time;
        
        

        
    }
    

}

/*
idea - basically dependent on a path from 0,0 to n-1, n-1
wait until enough rains falls for a path to exist


decrement the grid[][] values until there is a path of 0 and negative nums


other idea
use a heap 

and walk taking the smallest path until you arrive to the end of the matrix

the amount of time is the largest number we walked through
*/