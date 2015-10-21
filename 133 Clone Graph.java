/*
Clone Graph 

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();    // <original, clone>
        map.put(node, cloneNode);   // marke as cloned
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);    // // waite for processing
        
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.pop();
            UndirectedGraphNode cloneCur = map.get(cur);
            
            for(UndirectedGraphNode neib : cur.neighbors){
                if(!map.containsKey(neib)){ // uncloned
                    UndirectedGraphNode cloneNeib = new UndirectedGraphNode(neib.label);
                    map.put(neib, cloneNeib);   // mark as cloned
                    cloneCur.neighbors.add(cloneNeib);
                    queue.add(neib);    // enqueue and wait for processing
                }else{  // cloned
                    UndirectedGraphNode cloneNeib = map.get(neib);
                    cloneCur.neighbors.add(cloneNeib);
                }
            }
        }
        return cloneNode;
    }
}