/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> cloneMap = new HashMap();
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        if(cloneMap.containsKey(head)){
            return cloneMap.get(head);
        }
        
        Node cloneNode = new Node(head.val);
        cloneMap.put(head, cloneNode);
        
        cloneNode.next = copyRandomList(head.next);
        cloneNode.random = copyRandomList(head.random);
        
        return cloneNode;
        
    }
}