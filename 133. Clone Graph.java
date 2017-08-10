/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

Run BFS and matain the map to avoid duplicated copy.
Adjacent matrix.

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        Queue<UndirectedGraphNode> qu = new LinkedList<>();
        qu.offer(node);
        while(!qu.isEmpty()) {
            UndirectedGraphNode cur = qu.poll();
            UndirectedGraphNode n = map.get(cur);
            for (UndirectedGraphNode nei : cur.neighbors) {
                UndirectedGraphNode temp = map.get(nei);
                if (temp == null) {
                    qu.offer(nei);
                    UndirectedGraphNode newNei = new UndirectedGraphNode(nei.label);
                    map.put(nei, newNei);
                    n.neighbors.add(newNei);
                } else {
                    n.neighbors.add(temp);
                }
            }
        }
        return newNode;
    }
}
