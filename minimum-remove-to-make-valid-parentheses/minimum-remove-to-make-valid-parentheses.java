class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '('){
                stack.push(i);
            }
            if(sb.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }
        
        while(!stack.isEmpty()){
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
        
    }
}