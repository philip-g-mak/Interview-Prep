/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node pHead = new Node(-1, null, head, null);
        Node prev = pHead;
        Stack<Node> stack = new Stack();
        stack.add(head);
        
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            
             if(temp.next != null){
                stack.push(temp.next);
            }
            
            if(temp.child != null){
                stack.push(temp.child);
            }
            
            prev.next = temp;
            temp.prev = prev;
            temp.child = null;
            temp.next = null;
            
            prev = prev.next;
            
        }
        pHead.next.prev = null;
        
        return pHead.next;
    }
}

/*
DFS to traverse and rearrage the nodes
*/