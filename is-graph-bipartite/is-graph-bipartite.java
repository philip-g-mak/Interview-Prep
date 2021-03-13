class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        
        Stack<Integer> nodeStack = new Stack();
        
        for(int i = 0; i < colors.length; i++){
            if(colors[i] == -1){
                nodeStack.push(i);
                colors[i] = 1;
                
                while(!nodeStack.isEmpty()){
                    int home = nodeStack.pop();
                    
                    for(int neighbor : graph[home]){
                        if(colors[neighbor] == -1){
                            nodeStack.push(neighbor);
                            colors[neighbor] = (colors[home] + 1) %2;
                        } else if(colors[neighbor] == colors[home]) return false;
                    }
                }
            }
        }
        return true;
    }
}

/*
idea: 
bipartite means a graph can be colored - you can color a graph with 2 colors such that each node is a different color than its neighbor


to do this, set color of each node to -1 (not colored yet)
when visit set to 1
 then set neighbors to 0 and those neighbors to 1 etc etc use +1 %2 or XOR to change color
 
 if neighbor is colored, then check if it matches the home node - if same then not bipartite

*/