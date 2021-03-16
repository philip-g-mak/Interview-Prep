/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> cloneMap = new HashMap();
    public Node cloneGraph(Node node) {
        
        if(node == null) return node;
        
        if(cloneMap.containsKey(node)){
            return cloneMap.get(node);
        }
        
        Node cloneNode = new Node(node.val);
        cloneMap.put(node, cloneNode);
        
        for(Node neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }
}

/*

 CloneMap : 1-1, 2-2, 3-3, 4-4
       
 
 clone  = 1, [2,4]
          2, [1, 3]
          3, [2, 4]
          4, [1,3]

 [[2,4],[1,3],[2,4],[1,3]]
 
 
create a clone of this node-neighborhood

look at each node + their neighbors

so each node is seen at least twice

create a map <Orignal, Clone>
as I see each original node, i create a clone node, and putit into map

then when I go through the original node's neighbors - ill be able to pull from the map the cloned nodes
*/