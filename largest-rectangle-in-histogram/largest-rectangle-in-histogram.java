class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack();
        int maxArea =0;
        
        for(int i = 0; i <= len; i++){
            int h = i== len ? 0 : heights[i];
            
            if(stack.isEmpty() || h >= heights[stack.peek()]){
                stack.push(i);
            } else {
                int tp = stack.pop();
                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i -1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}