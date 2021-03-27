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

/*idea - use a stack to keep track of indexes of increasinge elments

loop i through heights:
    if height >= whats in the stack
        push i to stack
    else
        pop from stack;
        height is the value at whatever index you popped off
        
        width is if stack is empty, then what you have is smaller than all previoiusly seen heights 
            so width is i
            if stack is not empty - it is  i - the last large value seen which is stack.peek -1 
            
            set max area
            
return max area;

*/