class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> removeStack = new Stack();
        
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '('){
                removeStack.add(i);
            }
            
            if(sb.charAt(i) == ')'){
                if(removeStack.isEmpty()){
                    sb.deleteCharAt(i);
                    i--;
                } else {
                    removeStack.pop();
                }
            }
        }
        
        while(!removeStack.isEmpty()){
            sb.deleteCharAt(removeStack.pop());
        }
        
        return sb.toString();
    }
}